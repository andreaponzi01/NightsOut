package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.EventPageDecoratorAppController;
import nightsout.utils.EventParticipantsEngineering;
import nightsout.utils.Observer;
import nightsout.utils.bean.*;
import nightsout.utils.decorator.ConcreteComponent;
import nightsout.utils.decorator.ConcreteDecoratorPending;
import nightsout.utils.decorator.ConcreteDecoratorSendRequest;
import nightsout.utils.decorator.VisualComponent;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class EventPageDecoratorGUIController1 implements Observer {

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

    // Decorator
    @FXML
    private AnchorPane root;
    private ProfileBean bean;
    private String type;
    private String oldFxml;
    private Button myButton;
    private ConcreteComponent myConcreteComponent;
    private VisualComponent contents;

    @FXML
    private void backToClubOwnerPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        if(oldFxml.equals("/SearchPage1.fxml")) {
            replacer.switchAndSetScene(actionEvent, oldFxml, userBean, null);
        }
    }

    public void setAll(ProfileBean bean, EventBean eventBean, String oldFxml) throws SQLException {
        this.bean = bean;
        this.oldFxml = oldFxml;
        this.eventBean = eventBean;

        this.labelUsername.setText(eventBean.getName());
        this.labelEventName.setText(eventBean.getName());
        this.labelEventPrice.setText(String.valueOf(eventBean.getPrice()));
        this.labelEventDate.setText(String.valueOf(eventBean.getEventDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy"))));
        this.labelEventDuration.setText(String.valueOf(eventBean.getDuration()));
        this.labelEventTime.setText(String.valueOf(LocalTime.of(eventBean.getHours(), eventBean.getMinutes()).toString()));
        EventParticipantsEngineering.eventParticipants(this, eventBean.getIdEvent());

        this.bean = bean;
        this.type = bean.getType();

        if(this.type.equals("Free")) {
            this.userBean = EventPageDecoratorAppController.searchUsersByUsername(bean.getUsername());
        } else {
            this.clubOwnerBean = EventPageDecoratorAppController.searchClubOwnerByUsername(bean.getUsername());
        }

        myStart();
    }

    private void myStart() throws SQLException {

        this.myButton = new Button();
        this.myConcreteComponent = new ConcreteComponent(myButton);

        if(type.equals("Free")){
            RequestBean requestBean = EventPageDecoratorAppController.checkRequestStatus(this.userBean, this.eventBean);
            if (requestBean == null) {
                actionDecorateSendRequest();
            }
            else if (requestBean.getStatus().equals("pending")) {
                actionDecoratePending();
            } else if (requestBean.getStatus().equals("accepted")) {
                //actionDecorateAccepted(this.userBean);
                System.out.println("Accepted");
            } else if (requestBean.getStatus().equals("declined")){
                //actionDecorateDeclined(this.userBean);
                System.out.println("Declined");
            }
        }
        else {
            //actionDecorateDelete(this.clubOwnerBean);
            System.out.println("Delete");
        }
    }

    private void actionDecorateSendRequest() {
        ConcreteDecoratorSendRequest concreteDecoratorSendRequest = new ConcreteDecoratorSendRequest(this.myConcreteComponent, this.userBean, this.eventBean, this.oldFxml);
        this.contents = concreteDecoratorSendRequest;
        this.display();
    }

    private void actionDecoratePending() {
        ConcreteDecoratorPending concreteDecoratorPending = new ConcreteDecoratorPending(this.myConcreteComponent, this.userBean);
        this.contents = concreteDecoratorPending;
        this.display();
    }

    public void display() {
       // if(this.contents.getButton() != null) {
            this.root.getChildren().add(this.contents.getButton());
        //}
    }

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if(ob instanceof UserBean userBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/UserItem1.fxml")).openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            UserItemGUIController1 controller = fxmlLoader.getController();
            controller.setAll(userBean);
            this.listViewUsers.getItems().add(pane);
        }

    }
}
