package nightsout.control.guicontroller.interface1;

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
import nightsout.control.appcontroller.EventPageDecoratorAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.LoggedClubOwnerBean1;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.decorator.ConcreteComponent;
import nightsout.utils.decorator.ConcreteDecoratorDelete;
import nightsout.utils.decorator.VisualComponent;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.EventParticipantsEngineering;
import nightsout.utils.scene.switchPage.SwitchAndSetPage1;
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

public class EventPageDecoratorCOGUIController1 implements Observer, Initializable, MapComponentInitializedListener {

    private ClubOwnerBean1 clubOwnerBean1;
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
    private ImageView eventImg;

    @FXML
    private GoogleMapView location;

    // Decorator
    @FXML
    private AnchorPane root;
    private ConcreteComponent myConcreteComponent;
    private VisualComponent contents;

    public void setAll(EventBean1 eventBean1) throws SystemException {

            this.clubOwnerBean1 = LoggedClubOwnerBean1.getInstance();
            this.eventBean1 = eventBean1;
            clubOwnerBean1Event = new ClubOwnerBean1(EventPageDecoratorAppController.getClubOwner(eventBean1.getIdClubOwner()));
            this.buttonUsername.setText(clubOwnerBean1Event.getName());
            this.labelDescription.setText(eventBean1.getDescription());
            this.labelEventName.setText(eventBean1.getName());
            this.labelEventPrice.setText(String.valueOf(eventBean1.getPrice()) + " $");
            this.labelEventDate.setText(String.valueOf(eventBean1.getEventDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy"))));
            this.labelEventDuration.setText(String.valueOf(eventBean1.getDuration()) + " h");
            this.labelEventTime.setText(String.valueOf(eventBean1.getTime()));
            this.eventImg.setImage(new Image(this.eventBean1.getImg().toURI().toString()));
            EventParticipantsEngineering.eventParticipants(this, eventBean1.getIdEvent());
            myStart();
    }

    private void myStart(){

        this.myConcreteComponent = new ConcreteComponent();
        if(clubOwnerBean1.getId()== clubOwnerBean1Event.getId())
            actionDecorateDelete();
    }

    private void actionDecorateDelete() {

        ConcreteDecoratorDelete concreteDecoratorDelete = new ConcreteDecoratorDelete(this.myConcreteComponent, this.eventBean1);
        this.contents = concreteDecoratorDelete;
        this.display();
    }

    public void display() {
        this.root.getChildren().add(this.contents.getButton());
    }

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if(ob instanceof UserBean1 userBean1){
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/UserItem1.fxml")).openStream());
                UserItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(userBean1);
                this.listViewUsers.getItems().add(pane);
            } catch (IOException e) {
                MyNotification.createNotification(e);
            }

        }
    }

    @FXML
    public void goToMap(ActionEvent ae) {

        try {
            SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
            replacer.switchAndSetSceneEvent(ae, "/MapPage1.fxml", eventBean1);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    @FXML
    public void goToClubOwner(ActionEvent ae) {

        try {
            SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
            if(clubOwnerBean1.getId()== clubOwnerBean1Event.getId())
                replacer.switchAndSetScene(ae,"/ClubOwnerPage1.fxml");
            else
                replacer.switchAndSetSceneClubOwner(ae, "/ViewClubOwnerPageFromCO1.fxml", clubOwnerBean1Event);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
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

        double lat = 0.0;
        double lng = 0.0;

        try {

            address = EventPageDecoratorAppController.getClubAddress(eventBean1.getIdEvent());
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
            try {
                ExceptionHandler.handleException(e);
            } catch (SystemException ex) {
                MyNotification.createNotification(e);
            }
        } catch (SystemException e) {
            MyNotification.createNotification(e);
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

        markerOptions.position( new LatLong(46.935749, -121.483499))
                .visible(Boolean.TRUE)
                .title("Prova1" + "'s Location");

        Marker marker = new Marker(markerOptions);
        map.addMarker(marker);

    }
}
