package nightsout.control.guicontroller.interface1.user;

import com.dlsc.gmapsfx.GoogleMapView;
import com.dlsc.gmapsfx.MapComponentInitializedListener;
import com.dlsc.gmapsfx.javascript.object.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.EventPageAppController;
import nightsout.control.guicontroller.interface1.item.UserItemGUIController1;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.interface1.LoggedUserBean1;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.decorator.*;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.engineering.EventParticipantsEngineering;
import nightsout.utils.scene.switchpage.SwitchAndSetPage1;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class EventPageUserGUIController1 implements Observer, Initializable, MapComponentInitializedListener {

    private UserBean1 userBean1;
    private ClubOwnerBean1 clubOwnerBean1Event;
    private EventBean1 eventBean1;
    @FXML
    private Label labelEventName;
    @FXML
    private Button buttonUsername;
    @FXML
    private Label labelEventPrice;
    @FXML
    private Label labelEventDate;
    @FXML
    private Label labelEventTime;
    @FXML
    private Label labelEventDuration;
    @FXML
    private Label labelDescription;
    @FXML
    private ListView listViewUsers;
    @FXML
    private GoogleMapView location;
    @FXML
    private ImageView eventImg;
    // Decorator
    @FXML
    private AnchorPane root;
    private ConcreteComponent myConcreteComponent;
    private VisualComponent contents;

    public void setAll(EventBean1 eventBean1) throws SystemException {

            this.eventBean1 = eventBean1;
            this.userBean1 = LoggedUserBean1.getInstance();
            clubOwnerBean1Event = new ClubOwnerBean1(EventPageAppController.getClubOwner(eventBean1.getIdClubOwner()));
            this.buttonUsername.setText(clubOwnerBean1Event.getName());
            this.labelEventName.setText(eventBean1.getName());
            this.labelDescription.setText(eventBean1.getDescription());
            Double price= (eventBean1.getPrice()-((eventBean1.getPrice()* clubOwnerBean1Event.getDiscountVIP())/100));
            if(LoggedUserBean1.getInstance().getVip())
                this.labelEventPrice.setText("€" + price);
            else
                this.labelEventPrice.setText("€" + eventBean1.getPrice());
            this.labelEventDate.setText(eventBean1.getEventDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
            this.labelEventDuration.setText(eventBean1.getDuration() +"h");
            this.labelEventTime.setText(eventBean1.getTime().toString());
            this.eventImg.setImage(new Image(this.eventBean1.getImg().toURI().toString()));
            EventParticipantsEngineering.eventParticipants(this, eventBean1.getIdEvent());
            myStart();
    }
    private void myStart() throws SystemException {

        this.myConcreteComponent = new ConcreteComponent();
        RequestBean requestBean = EventPageAppController.checkRequestStatus(this.userBean1, this.eventBean1);
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

        ConcreteDecoratorSendRequest1 concreteDecoratorSendRequest1 = new ConcreteDecoratorSendRequest1(this.myConcreteComponent, this.eventBean1);
        this.contents = concreteDecoratorSendRequest1;
        this.display();
    }
    private void actionDecoratePending() {

        ConcreteDecoratorPending concreteDecoratorPending = new ConcreteDecoratorPending(this.myConcreteComponent);
        this.contents = concreteDecoratorPending;
        this.display();
    }
    private void actionDecorateAccepted() {

        ConcreteDecoratorAccepted concreteDecoratorAccepted = new ConcreteDecoratorAccepted(this.myConcreteComponent);
        this.contents = concreteDecoratorAccepted;
        this.display();
    }
    private void actionDecorateDeclined() {

        ConcreteDecoratorDeclined concreteDecoratorDeclined = new ConcreteDecoratorDeclined(this.myConcreteComponent);
        this.contents = concreteDecoratorDeclined;
        this.display();
    }
    public void display() { this.root.getChildren().add(this.contents.getButton()); }

    @FXML
    public void goToMap(ActionEvent ae) {

        try {
            SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
            replacer.switchAndSetSceneEvent(ae, "/MapPage1.fxml", eventBean1);
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }

    @FXML
    public void goToClubOwner(ActionEvent ae) {

        try {
            SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
            replacer.switchAndSetSceneClubOwner(ae, "/ViewClubOwnerPageFromUser1.fxml", clubOwnerBean1Event);
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        location.addMapInitializedListener(this);
    }

    @Override
    public void mapInitialized() {

        String address = "";

        MapOptions mapOptions = new MapOptions();
        Double lat = 0.0;
        Double lng = 0.0;

        try {
            address = EventPageAppController.getClubAddress(eventBean1.getIdEvent());
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

            InputStream in = con.getInputStream();
            String encoding = con.getContentEncoding();
            encoding = encoding == null ? "UTF-8" : encoding;
            // Richiede Java 9 o versioni successive
            String body = new String(in.readAllBytes(), encoding);

            JSONObject object = new JSONObject(body);

            lat = Double.parseDouble(object.getJSONArray("results").getJSONObject(0).getJSONArray("locations").getJSONObject(0).getJSONObject("latLng").getString("lat"));
            lng = Double.parseDouble(object.getJSONArray("results").getJSONObject(0).getJSONArray("locations").getJSONObject(0).getJSONObject("latLng").getString("lng"));
            http.disconnect();

        } catch (JSONException | IOException e) {
            ExceptionHandler.handleException(e);
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }

        // Creiamo la mappa centrata sulla latitudine e longitudine corrispondente all'indirizzo del Club nel quale si svolgerà l'evento
        mapOptions.center(new LatLong(lat,lng))
                .mapType(MapTypeIdEnum.HYBRID)
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

        markerOptions.position(new LatLong(lat, lng))
                .visible(Boolean.TRUE)
                .title("Prova1" + "'s Location");

        Marker marker = new Marker(markerOptions);
        map.addMarker(marker);
    }

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if(ob instanceof UserBean uBean){

            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/UserItem1.fxml")).openStream());
                UserItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(new UserBean1(uBean));
                this.listViewUsers.getItems().add(pane);
            } catch (IOException e) {
                CreateNotification.createNotification(e);
            }

        }
    }
}
