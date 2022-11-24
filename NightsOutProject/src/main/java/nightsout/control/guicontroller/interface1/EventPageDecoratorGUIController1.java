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
import nightsout.utils.observer.engineering.EventParticipantsEngineering;
import nightsout.utils.observer.Observer;
import nightsout.utils.bean.*;
import nightsout.utils.decorator.*;
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
    private String prevOldFxml;
    private Button myButton;
    private ConcreteComponent myConcreteComponent;
    private VisualComponent contents;

    @FXML
    private void back(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        if(oldFxml.equals("/SearchPage1.fxml")) {
            replacer.switchAndSetSceneSearch(actionEvent, oldFxml, this.userBean);
        } else if(oldFxml.equals("/EndedBookedEventsPage1.fxml")) {
            replacer.switchAndSetSceneEndedBookedEvents(actionEvent, oldFxml, this.userBean);
        } else if(oldFxml.equals("/ClubOwnerPage1.fxml")) {
            replacer.switchAndSetScene(actionEvent, oldFxml, null, this.clubOwnerBean);
        } else if (oldFxml.equals("/CheckRequestsPage1.fxml")) {
            replacer.switchAndSetSceneCheckRequests(actionEvent, oldFxml, this.userBean);
        } else if (oldFxml.equals("/UserPage1.fxml")) {
            replacer.switchAndSetScene(actionEvent, oldFxml, userBean, null);
        } else if (oldFxml.equals("/ViewClubOwnerPage1.fxml")) {
            replacer.switchAndSetSceneViewClubOwnerPage(actionEvent, "/ViewClubOwnerPage1.fxml", this.userBean, this.clubOwnerBean, this.prevOldFxml);
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

        /*if (this.type.equals("Free") && ) {

        } else*/ if (this.type.equals("Free")) {
            this.userBean = EventPageDecoratorAppController.searchUsersByUsername(bean.getUsername());
        } else {
            this.clubOwnerBean = EventPageDecoratorAppController.searchClubOwnerByUsername(bean.getUsername());
        }

        myStart();
    }

    /*
        PROBLEMA: per come avevo implementato la ViewClubOwnerPage e il Decorator,
        se si visualizzava la pagina dell'evento dalla ricerca (quindi lato Free User)
        veniva visualizzata la decorazione del Club Owner e non quella dell'User.

        IMPORTANTE: Da sistemare questo utilizzo di setAll2 e setterDecorator2! Capire se va bene utilizzare prevOldFxml
     */
    public void setAll2(UserBean userBean, ClubOwnerBean clubOwnerBean, EventBean eventBean, String oldFxml, String prevOldFxml) throws SQLException {
        this.bean = userBean;
        this.clubOwnerBean = clubOwnerBean;
        this.oldFxml = oldFxml;
        this.prevOldFxml = prevOldFxml;
        this.eventBean = eventBean;

        this.labelUsername.setText(eventBean.getName());
        this.labelEventName.setText(eventBean.getName());
        this.labelEventPrice.setText(String.valueOf(eventBean.getPrice()));
        this.labelEventDate.setText(String.valueOf(eventBean.getEventDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy"))));
        this.labelEventDuration.setText(String.valueOf(eventBean.getDuration()));
        this.labelEventTime.setText(String.valueOf(LocalTime.of(eventBean.getHours(), eventBean.getMinutes()).toString()));
        EventParticipantsEngineering.eventParticipants(this, eventBean.getIdEvent());

        this.type = bean.getType();
        this.userBean = EventPageDecoratorAppController.searchUsersByUsername(bean.getUsername());

        myStart();
    }

    private void myStart() throws SQLException {

        this.myConcreteComponent = new ConcreteComponent();

        if(type.equals("Free")){
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
        } else {
            actionDecorateDelete();
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

    private void actionDecorateAccepted() {
        ConcreteDecoratorAccepted concreteDecoratorAccepted = new ConcreteDecoratorAccepted(this.myConcreteComponent, this.userBean);
        this.contents = concreteDecoratorAccepted;
        this.display();
    }

    private void actionDecorateDeclined() {
        ConcreteDecoratorDeclined concreteDecoratorDeclined = new ConcreteDecoratorDeclined(this.myConcreteComponent, this.userBean);
        this.contents = concreteDecoratorDeclined;
        this.display();
    }

    private void actionDecorateDelete() {
        ConcreteDecoratorDelete concreteDecoratorDelete = new ConcreteDecoratorDelete(this.myConcreteComponent, this.clubOwnerBean, this.eventBean);
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

        if(ob instanceof UserBean userBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/UserItem1.fxml")).openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            UserItemGUIController1 controller = fxmlLoader.getController();
            controller.setAll(userBean, this.eventBean, this.oldFxml);
            this.listViewUsers.getItems().add(pane);
        }

    }


}
