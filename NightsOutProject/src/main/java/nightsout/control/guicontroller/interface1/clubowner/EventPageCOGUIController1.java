package nightsout.control.guicontroller.interface1.clubowner;

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
import nightsout.control.appcontroller.EventPageAppController;
import nightsout.control.guicontroller.interface1.item.UserItemGUIController1;
import nightsout.utils.Session;
import nightsout.utils.bean.UserBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.decorator.Component;
import nightsout.utils.decorator.ConcreteComponent;
import nightsout.utils.decorator.ConcreteDecoratorDelete1;
import nightsout.utils.engineering.EventParticipantsEngineering;
import nightsout.utils.engineering.MapEngineering;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.scene.switchpage.SwitchAndSetPage1;
import nightsout.utils.scene.switchpage.SwitchPage;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class EventPageCOGUIController1 implements Observer, Initializable, MapComponentInitializedListener {

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
    private Component contents;

    private SwitchPage switchPage = new SwitchPage();
    private SwitchAndSetPage1 switchAndSetPage1 = new SwitchAndSetPage1();

    public void setAll(EventBean1 eventBean1) throws SystemException {

            EventPageAppController controller = new EventPageAppController();
            this.clubOwnerBean1 = new ClubOwnerBean1(Session.getInstance().getClubOwner());
            this.eventBean1 = eventBean1;
            clubOwnerBean1Event = new ClubOwnerBean1(controller.getClubOwner(eventBean1.getIdClubOwner()));
            this.buttonUsername.setText(clubOwnerBean1Event.getName());
            this.labelDescription.setText(eventBean1.getDescription());
            this.labelEventName.setText(eventBean1.getName());
            this.labelEventPrice.setText(eventBean1.getPrice() + " $");
            this.labelEventDate.setText(eventBean1.getEventDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
            this.labelEventDuration.setText(eventBean1.getDuration() + " h");
            this.labelEventTime.setText(String.valueOf(eventBean1.getTime()));
            this.eventImg.setImage(new Image(this.eventBean1.getImg().toURI().toString()));
            EventParticipantsEngineering eventParticipantsEngineering = new EventParticipantsEngineering();
            eventParticipantsEngineering.eventParticipants(this, eventBean1.getIdEvent());
            myStart();
    }

    private void myStart(){

        this.myConcreteComponent = new ConcreteComponent();
        if(clubOwnerBean1.getId()== clubOwnerBean1Event.getId())
            actionDecorateDelete();
    }

    private void actionDecorateDelete() {

        ConcreteDecoratorDelete1 concreteDecoratorDelete = new ConcreteDecoratorDelete1(this.myConcreteComponent, this.eventBean1);
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

        if(ob instanceof UserBean userBean){
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/UserItem1.fxml")).openStream());
                UserItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(new UserBean1(userBean));
                this.listViewUsers.getItems().add(pane);
            } catch (IOException e) {
                ErrorDialog.getInstance().handleException(e);
            }

        }
    }

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
            if (clubOwnerBean1.getId() == clubOwnerBean1Event.getId())
                switchPage.replaceScene(ae, "/ClubOwnerPage1.fxml");
            else {
                switchAndSetPage1.switchAndSetSceneClubOwner(ae, "/ViewClubOwnerPageFromCO1.fxml", clubOwnerBean1Event);
            }
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

    }
}
