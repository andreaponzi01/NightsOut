package nightsout.control.guicontroller.interface2;

import com.dlsc.gmapsfx.GoogleMapView;
import com.dlsc.gmapsfx.MapComponentInitializedListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.utils.Session;
import nightsout.utils.bean.IdBean;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.interface2.ClubOwnerBean2;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.decorator.*;
import nightsout.utils.engineering.EventPageEngineering;
import nightsout.utils.engineering.MapEngineering;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchAndSetPage2;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class EventPageGUIController2 implements Initializable, MapComponentInitializedListener {

    private UserBean2 userBean;
    private ClubOwnerBean2 clubOwnerBean2;
    private ClubOwnerBean2 clubOwnerBeanEvent;
    private EventBean2 eventBean;
    private SwitchAndSetPage2 switchAndSetPage2 = new SwitchAndSetPage2();

    @FXML
    private Label labelEventDate;
    @FXML
    private Label labelEventTime;
    @FXML
    private Label labelEventDuration;
    @FXML
    private Label labelEventPrice;
    @FXML
    private Label labelDescription;
    @FXML
    private Button buttonUsername;
    @FXML
    private GoogleMapView location;
    @FXML
    private ImageView eventImg;
    @FXML
    private Label labelEventName;


    // Decorator
    @FXML
    private AnchorPane root;
    private ConcreteComponent myConcreteComponent;
    private Component contents;
    private EventPageEngineering eventPageEngineering = new EventPageEngineering();
    private JoinEventAppController joinEventAppController;

    public void setAll(EventBean2 eventBean) throws SystemException {

        this.eventBean = eventBean;
        clubOwnerBeanEvent = new ClubOwnerBean2(eventPageEngineering.getClubOwner(new IdBean(eventBean.getIdClubOwner())));
        if(Session.getInstance().checkInstanceType().equalsIgnoreCase("Free")) {
            this.userBean = new UserBean2(Session.getInstance().getUser());
            Double price = (eventBean.getPrice() - ((eventBean.getPrice() * clubOwnerBeanEvent.getDiscountVIP()) / 100));
            if (Session.getInstance().getUser().getVip())
                this.labelEventPrice.setText("€" + price);
            else
                this.labelEventPrice.setText("€" + eventBean.getPrice());
        } else {
            this.clubOwnerBean2 = new ClubOwnerBean2(Session.getInstance().getClubOwner());
            this.labelEventPrice.setText(eventBean.getPrice() + " €");
        }
        this.labelEventDate.setText(eventBean.getEventDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
        this.labelEventDuration.setText(eventBean.getDuration() +"h");
        this.labelEventTime.setText(eventBean.getTime().toString());
        this.eventImg.setImage(new Image(this.eventBean.getImg().toURI().toString()));
        this.buttonUsername.setText(clubOwnerBeanEvent.getName());
        this.labelEventName.setText(eventBean.getName());
        this.labelDescription.setText(eventBean.getDescription());

        myStart();
    }

    public void setAll(EventBean2 eventBean, JoinEventAppController joinEventAppController) throws SystemException {

        this.joinEventAppController = joinEventAppController;
        setAll(eventBean);
    }

    private void myStart() throws SystemException {

        this.myConcreteComponent = new ConcreteComponent();
        if (Session.getInstance().checkInstanceType().equalsIgnoreCase("Free")) {

            if(joinEventAppController==null)
                joinEventAppController = new JoinEventAppController();

            RequestBean requestBean = eventPageEngineering.checkRequestStatus(this.userBean, this.eventBean);
            if (requestBean == null) {
                if (eventBean.getEventDate().isAfter(LocalDate.now()))
                    actionDecorateSendRequest();
            } else if (requestBean.getStatus().equals("pending")) {
                actionDecoratePending();
            } else if (requestBean.getStatus().equals("accepted")) {
                actionDecorateAccepted();
            } else if (requestBean.getStatus().equals("declined")) {
                actionDecorateDeclined();
            }
        } else {
            if(clubOwnerBean2.getId() == clubOwnerBeanEvent.getId())
                actionDecorateDelete();
        }
    }

    private void actionDecorateAccepted() {

        ConcreteDecoratorAccepted concreteDecoratorAccepted = new ConcreteDecoratorAccepted(this.myConcreteComponent);
        this.contents = concreteDecoratorAccepted;
        this.display();
    }
    private void actionDecoratePending() {

        ConcreteDecoratorPending concreteDecoratorPending = new ConcreteDecoratorPending(this.myConcreteComponent);
        this.contents = concreteDecoratorPending;
        this.display();
    }
    private void actionDecorateDelete() {

        ConcreteDecoratorDelete2 concreteDecoratorDelete = new ConcreteDecoratorDelete2(this.myConcreteComponent, this.eventBean);
        this.contents = concreteDecoratorDelete;
        this.display();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        location.addMapInitializedListener(this);
    }

    @Override
    public void mapInitialized() {
        MapEngineering mapEngineering = new MapEngineering();
        mapEngineering.createMap(eventBean, location);
    }
    private void actionDecorateSendRequest() {

        ConcreteDecoratorSendRequest2 concreteDecoratorSendRequest2 = new ConcreteDecoratorSendRequest2(this.myConcreteComponent, this.eventBean, joinEventAppController);
        this.contents = concreteDecoratorSendRequest2;
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
            if (Session.getInstance().checkInstanceType().equalsIgnoreCase("Free"))
                switchAndSetPage2.switchAndSetSceneEvent(ae, "/EventParticipantsPageFromUser2.fxml", eventBean, joinEventAppController);
            else
                switchAndSetPage2.switchAndSetSceneEvent(ae, "/EventParticipantsPageFromCO2.fxml", eventBean);

        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
    @FXML
    public void goToClubOwner(ActionEvent ae) {

        try {
            if (Session.getInstance().checkInstanceType().equalsIgnoreCase("Free"))
                switchAndSetPage2.switchAndSetSceneCO(ae, "/ViewCOPageFromUser2.fxml", clubOwnerBeanEvent, joinEventAppController);
            else
                switchAndSetPage2.switchAndSetSceneCO(ae, "/ViewCOPageFromCO2.fxml", clubOwnerBeanEvent);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }


}
