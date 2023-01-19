package nightsout.control.guicontroller.interface1;

import com.dlsc.gmapsfx.GoogleMapView;
import com.dlsc.gmapsfx.MapComponentInitializedListener;
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
import nightsout.control.appcontroller.CheckRequestAppController;
import nightsout.control.appcontroller.EventPageAppController;
import nightsout.control.guicontroller.interface1.item.UserItemGUIController1;
import nightsout.utils.Session;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.decorator.*;
import nightsout.utils.engineering.EventParticipantsEngineering;
import nightsout.utils.engineering.MapEngineering;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.scene.switchpage.SwitchAndSetPage1;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class EventPageGUIController1 implements Observer, Initializable, MapComponentInitializedListener {

    private UserBean1 userBean1;
    private ClubOwnerBean1 clubOwnerBean1;
    private ClubOwnerBean1 clubOwnerBean1Event;
    private EventBean1 eventBean1;
    private SwitchAndSetPage1 switchAndSetPage1 = new SwitchAndSetPage1();
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
    private Component contents;

    public void setAll(EventBean1 eventBean1) throws SystemException {

        EventPageAppController controller  = new EventPageAppController();
        this.eventBean1 = eventBean1;
        clubOwnerBean1Event = new ClubOwnerBean1(controller.getClubOwner(eventBean1.getIdClubOwner()));

        if(Session.getInstance().checkInstanceType().equalsIgnoreCase("Free")) {
            this.userBean1 = new UserBean1(Session.getInstance().getUser());
            Double price = (eventBean1.getPrice() - ((eventBean1.getPrice() * clubOwnerBean1Event.getDiscountVIP()) / 100));
            if (Session.getInstance().getUser().getVip())
                this.labelEventPrice.setText("€" + price);
            else
                this.labelEventPrice.setText("€" + eventBean1.getPrice());
        } else {
            this.clubOwnerBean1 = new ClubOwnerBean1(Session.getInstance().getClubOwner());
            this.labelEventPrice.setText(eventBean1.getPrice() + " €");
        }

        this.buttonUsername.setText(clubOwnerBean1Event.getName());
        this.labelEventName.setText(eventBean1.getName());
        this.labelDescription.setText(eventBean1.getDescription());
        this.labelEventDate.setText(eventBean1.getEventDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
        this.labelEventDuration.setText(eventBean1.getDuration() + "h");
        this.labelEventTime.setText(eventBean1.getTime().toString());
        this.eventImg.setImage(new Image(this.eventBean1.getImg().toURI().toString()));

        EventParticipantsEngineering eventParticipantsEngineering = new EventParticipantsEngineering();
        eventParticipantsEngineering.eventParticipants(this, eventBean1.getIdEvent());
        myStart();
    }
    private void myStart() throws SystemException {

        CheckRequestAppController controller = new CheckRequestAppController();

        if (Session.getInstance().checkInstanceType().equalsIgnoreCase("Free")) {
            this.myConcreteComponent = new ConcreteComponent();
            RequestBean requestBean = controller.checkRequestStatus(this.userBean1, this.eventBean1);
            if (requestBean == null) {
                if (eventBean1.getEventDate().isAfter(LocalDate.now()))
                    actionDecorateSendRequest();
            } else if (requestBean.getStatus().equals("pending")) {
                actionDecoratePending();
            } else if (requestBean.getStatus().equals("accepted")) {
                actionDecorateAccepted();
            } else if (requestBean.getStatus().equals("declined")) {
                actionDecorateDeclined();
            }
        } else {
            this.myConcreteComponent = new ConcreteComponent();
            if(clubOwnerBean1.getId()== clubOwnerBean1Event.getId())
                actionDecorateDelete();
        }
    }

    private void actionDecorateDelete() {

        ConcreteDecoratorDelete1 concreteDecoratorDelete = new ConcreteDecoratorDelete1(this.myConcreteComponent, this.eventBean1);
        this.contents = concreteDecoratorDelete;
        this.display();
    }

    private void actionDecorateSendRequest() {

        ConcreteDecoratorSendRequest1 concreteDecoratorSendRequest = new ConcreteDecoratorSendRequest1(this.myConcreteComponent, this.eventBean1);
        this.contents = concreteDecoratorSendRequest;
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
            switchAndSetPage1.switchAndSetSceneEvent(ae, "/MapPage1.fxml", eventBean1);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    public void goToClubOwner(ActionEvent ae) {

        try {
            switchAndSetPage1.switchAndSetSceneClubOwner(ae, "/ViewClubOwnerPageFromUser1.fxml", clubOwnerBean1Event);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        location.addMapInitializedListener(this);
    }

    @Override
    public void mapInitialized() {
        MapEngineering mapEngineering = new MapEngineering();
        mapEngineering.createMap(eventBean1, location);
    /*
        MapOptions mapOptions = new MapOptions();
        Double[] latlong= new Double[2];
        try {
            latlong = EventPageAppController.findLocation(eventBean1.getIdEvent());
        } catch (SystemException e) {
            ExceptionHandler.getInstance().handleException(e);
        }

        // Creiamo la mappa centrata sulla latitudine e longitudine corrispondente all'indirizzo del Club nel quale si svolgerà l'evento
        mapOptions.center(new LatLong(latlong[0],latlong[1]))
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

        markerOptions.position(new LatLong(latlong[0],latlong[1]))
                .visible(Boolean.TRUE)
                .title("Prova1" + "'s Location");

        Marker marker = new Marker(markerOptions);
        map.addMarker(marker);

     */
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
                ErrorDialog.getInstance().handleException(e);
            }

        }
    }
}
