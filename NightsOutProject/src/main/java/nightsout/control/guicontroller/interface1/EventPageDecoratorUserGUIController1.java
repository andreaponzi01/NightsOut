package nightsout.control.guicontroller.interface1;

import com.dlsc.gmapsfx.GoogleMapView;
import com.dlsc.gmapsfx.MapComponentInitializedListener;
import com.dlsc.gmapsfx.javascript.object.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.EventPageDecoratorAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.engineering.EventParticipantsEngineering;
import nightsout.utils.observer.Observer;
import nightsout.utils.bean.*;
import nightsout.utils.decorator.*;
import nightsout.utils.scene.ReplaceSceneDynamic1;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class EventPageDecoratorUserGUIController1 implements Observer, Initializable, MapComponentInitializedListener {

    private UserBean userBean;

    private ClubOwnerBean clubOwnerBean;
    private EventBean eventBean;
    @FXML
    private Label labelEventName;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelEventPrice;
    @FXML
    private Label labelEventDate;
    @FXML
    private Label labelEventTime;
    @FXML
    private Label labelEventDuration;
    @FXML
    private ListView listViewUsers;
    @FXML
    GoogleMapView location;

    // Decorator
    @FXML
    private AnchorPane root;
    private ConcreteComponent myConcreteComponent;
    private VisualComponent contents;
    @FXML
    private MenuUserGUIController1 menuController;

    public void setAll( EventBean eventBean) throws SQLException, SystemException {
        this.menuController.setAll();
        this.eventBean = eventBean;
        this.userBean=LoggedUserBean.getInstance();
        clubOwnerBean=EventPageDecoratorAppController.getClubOwner(eventBean.getIdClubOwner());
        this.labelUsername.setText(clubOwnerBean.getName());
        this.labelEventName.setText(eventBean.getName());
        this.labelEventPrice.setText(String.valueOf(eventBean.getPrice()));
        this.labelEventDate.setText(String.valueOf(eventBean.getEventDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy"))));
        this.labelEventDuration.setText(String.valueOf(eventBean.getDuration()));
        this.labelEventTime.setText(String.valueOf(LocalTime.of(eventBean.getHours(), eventBean.getMinutes()).toString()));
        EventParticipantsEngineering.eventParticipants(this, eventBean.getIdEvent());
        myStart();
    }

    private void myStart() throws SystemException {

        this.myConcreteComponent = new ConcreteComponent();
        RequestBean requestBean = EventPageDecoratorAppController.checkRequestStatus(this.userBean, this.eventBean);
        if (requestBean == null) {
            actionDecorateSendRequest();
        }
        else if (requestBean.getStatus().equals("pending")) {
            actionDecoratePending();
        } else if (requestBean.getStatus().equals("accepted")) {
            actionDecorateAccepted();
        } else if (requestBean.getStatus().equals("declined")){
            actionDecorateDeclined();
        }
    }

    private void actionDecorateSendRequest() {
        ConcreteDecoratorSendRequest concreteDecoratorSendRequest = new ConcreteDecoratorSendRequest(this.myConcreteComponent, this.eventBean);
        this.contents = concreteDecoratorSendRequest;
        this.display();
    }

    private void actionDecoratePending() {
        ConcreteDecoratorPending concreteDecoratorPending = new ConcreteDecoratorPending(this.myConcreteComponent);
        this.contents = concreteDecoratorPending;
        this.display();
    }

    private void actionDecorateAccepted(){
        ConcreteDecoratorAccepted concreteDecoratorAccepted = new ConcreteDecoratorAccepted(this.myConcreteComponent);
        this.contents = concreteDecoratorAccepted;
        this.display();
    }

    private void actionDecorateDeclined(){
        ConcreteDecoratorDeclined concreteDecoratorDeclined = new ConcreteDecoratorDeclined(this.myConcreteComponent);
        this.contents = concreteDecoratorDeclined;
        this.display();
    }

    public void display(){
        this.root.getChildren().add(this.contents.getButton());
    }

    @Override
    public void update(Object ob){

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if(ob instanceof UserBean userBean){
            try{
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/UserItem1.fxml")).openStream());
            }catch (IOException e){
                e.printStackTrace();
            }

            UserItemGUIController1 controller = fxmlLoader.getController();
            controller.setAll(userBean);
            this.listViewUsers.getItems().add(pane);

        }
    }
    @FXML
    public void goToMap(ActionEvent ae) throws SystemException {
        ReplaceSceneDynamic1 replacer= new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneMap(ae,"/MapPage1.fxml",eventBean);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        location.addMapInitializedListener(this);
    }

    @Override
    public void mapInitialized() {

        String address = "";

        MapOptions mapOptions = new MapOptions();
        double lat = 0.0, lng = 0.0;

        try {
            address = EventPageDecoratorAppController.getClubAddress(eventBean.getIdEvent());
            // Recuperiamo latitudine e longitudine dell'indirizzo del Club nel quale si svolgerà l'evento
            URL url = new URL("https://www.mapquestapi.com/geocoding/v1/address?key=QmskMXX88teOI9qXndnvrgGj4DGETyiF");

            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) con;

            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setRequestProperty("Content-Type", "application/json");

            String data = "{\n  \"location\": \"" + address  + "\",\n  \"options\": {\n    \"thumbMaps\": true\n  }\n}";
            byte[] out = data.getBytes(StandardCharsets.UTF_8);

            OutputStream stream = http.getOutputStream();
            stream.write(out);

            System.out.println(http.getResponseCode() + " " + http.getResponseMessage());

            InputStream in = con.getInputStream();
            String encoding = con.getContentEncoding();
            encoding = encoding == null ? "UTF-8" : encoding;
            // Richiede Java 9 o versioni successive
            String body = new String(in.readAllBytes(), encoding);
            System.out.println(body);

            JSONObject object = new JSONObject(body);

            lat = Double.parseDouble(object.getJSONArray("results").getJSONObject(0).getJSONArray("locations").getJSONObject(0).getJSONObject("latLng").getString("lat"));
            lng = Double.parseDouble(object.getJSONArray("results").getJSONObject(0).getJSONArray("locations").getJSONObject(0).getJSONObject("latLng").getString("lng"));
            http.disconnect();

        } catch (JSONException | IOException e) {
            try {
                ExceptionHandler.handleException(e);
            } catch (SystemException ex) {
                MyNotification.createNotification(e);
            }
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }

        // Creiamo la mappa centrata sulla latitudine e longitudine corrispondente all'indirizzo del Club nel quale si svolgerà l'evento
        mapOptions.center(new LatLong(lat, lng))
                .mapType(MapTypeIdEnum.SATELLITE)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(18);

        GoogleMap map = location.createMap(mapOptions);

        // Aggiungiamo il marcatore sulla Mappa
        MarkerOptions markerOptions = new MarkerOptions();

        markerOptions.position( new LatLong(lat, lng))
                .visible(Boolean.TRUE)
                .title("Prova1" + "'s Location");

        Marker marker = new Marker(markerOptions);
        map.addMarker(marker);

    /*
    URL url2 = null;
    try {
        url2 = new URL("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/marracash-carriera-vita-foto-gossip-album-1641325823.png");    } catch (MalformedURLException e) {
        e.printStackTrace();
        try {
            url2 = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1024px-No_image_available.svg.png");        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
    }
    Image image = new Image(String.valueOf(url2));
    profilePic.setImage(image);
    */
    }
}
