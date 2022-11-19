package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.EventPageAppController;
import nightsout.utils.EventParticipantsEngineering;
import nightsout.utils.Observer;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class EventPageUserGUIController1 implements Observer {

    private UserBean userBean;
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
    private ClubOwnerBean clubOwnerBean;

    @FXML
    private void backToUserPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneEndedBookedEvents(actionEvent, "/EndedBookedEventsPage1.fxml", userBean);
    }


    public void setAll(UserBean userBean, EventBean eventBean) throws SQLException {
        this.userBean = userBean;
        this.eventBean = eventBean;
        this.labelUsername.setText(eventBean.getName());
        this.labelEventName.setText(eventBean.getName());
        this.clubOwnerBean= EventPageAppController.getClubOwner(eventBean.getIdClubOwner());
        if(userBean.getVip()){
            this.labelEventPrice.setText(String.valueOf(eventBean.getPrice()-((eventBean.getPrice()/100)*clubOwnerBean.getDiscountVIP())));
        }else{
            this.labelEventPrice.setText(String.valueOf(eventBean.getPrice()));

        }
        this.labelEventDate.setText(String.valueOf(eventBean.getEventDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy"))));
        this.labelEventDuration.setText(String.valueOf(eventBean.getDuration()));
        this.labelEventTime.setText(String.valueOf(LocalTime.of(eventBean.getHours(), eventBean.getMinutes()).toString()));
        EventParticipantsEngineering.eventParticipants(this, eventBean.getIdEvent());
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
