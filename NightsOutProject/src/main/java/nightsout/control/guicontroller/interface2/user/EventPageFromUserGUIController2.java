package nightsout.control.guicontroller.interface2.user;

import com.dlsc.gmapsfx.GoogleMapView;
import com.dlsc.gmapsfx.MapComponentInitializedListener;
import com.dlsc.gmapsfx.javascript.object.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import nightsout.control.appcontroller.EventPageAppController;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.interface2.ClubOwnerBean2;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.bean.interface2.LoggedUserBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.decorator.*;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage2;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class EventPageFromUserGUIController2 implements Initializable, MapComponentInitializedListener {

    private UserBean2 userBean;
    private ClubOwnerBean2 clubOwnerBeanEvent;
    private EventBean2 eventBean;
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
    private GoogleMapView location;
    @FXML
    private ImageView eventImg;
    // Decorator
    @FXML
    private AnchorPane root;
    private ConcreteComponent myConcreteComponent;
    private VisualComponent contents;

    public void setAll(EventBean2 eventBean) throws SystemException {

        this.eventBean = eventBean;
        this.userBean = LoggedUserBean2.getInstance();
        clubOwnerBeanEvent = new ClubOwnerBean2(EventPageAppController.getClubOwner(eventBean.getIdClubOwner()));
        this.buttonUsername.setText(clubOwnerBeanEvent.getName());
        this.labelEventName.setText(eventBean.getName());
        this.labelDescription.setText(eventBean.getDescription());
        Double price= (eventBean.getPrice()-((eventBean.getPrice()*clubOwnerBeanEvent.getDiscountVIP())/100));
        if(LoggedUserBean2.getInstance().getVip())
            this.labelEventPrice.setText("€" + price);
        else
            this.labelEventPrice.setText("€" + eventBean.getPrice());
        this.labelEventDate.setText(eventBean.getEventDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
        this.labelEventDuration.setText(eventBean.getDuration() +"h");
        this.labelEventTime.setText(eventBean.getTime().toString());
        this.eventImg.setImage(new Image(this.eventBean.getImg().toURI().toString()));

        myStart();
    }

    private void myStart() throws SystemException {

        this.myConcreteComponent = new ConcreteComponent();
        RequestBean requestBean = EventPageAppController.checkRequestStatus(this.userBean, this.eventBean);
        if (requestBean == null) {
                if(eventBean.getEventDate().isAfter(LocalDate.now()))
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

        ConcreteDecoratorSendRequest2 concreteDecoratorSendRequest2 = new ConcreteDecoratorSendRequest2(this.myConcreteComponent, this.eventBean);
        this.contents = concreteDecoratorSendRequest2;
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
    public void goToParticipantsPage(ActionEvent ae) {

        try {
            SwitchAndSetPage2 replacer = new SwitchAndSetPage2();
            replacer.switchAndSetSceneEvent(ae, "/EventParticipantsPage2.fxml", eventBean);
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }
    @FXML
    public void goToClubOwner(ActionEvent ae) {

        try {
            SwitchAndSetPage2 replacer = new SwitchAndSetPage2();
            replacer.switchAndSetSceneCO(ae, "/ViewCOPageFromUser2.fxml", clubOwnerBeanEvent);
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
            address = EventPageAppController.getClubAddress(eventBean.getIdEvent());
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
                .title("Event" + "'s Location");

        Marker marker = new Marker(markerOptions);
        map.addMarker(marker);
    }
}
