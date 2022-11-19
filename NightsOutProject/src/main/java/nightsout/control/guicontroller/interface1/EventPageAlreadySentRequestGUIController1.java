package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.EventPageAppController;
import nightsout.control.appcontroller.UserPageAppController;
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

public class EventPageAlreadySentRequestGUIController1 implements Observer {

    private UserBean userBean;
    private ClubOwnerBean clubOwnerBean;
    private EventBean eventBean;

    private String oldInput;

    @FXML
    Button buttonUsername;
    @FXML
    Label labelEventName;
    @FXML
    Label labelEventPrice;
    @FXML
    Label labelEventDate;
    @FXML
    Label labelEventTime;
    @FXML
    Label labelEventDuration;
    @FXML
     ListView listView;

    @FXML
    private void backToSearchPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneOldSearch(actionEvent, "/SearchPage1.fxml", userBean, oldInput);
    }

    @FXML
    private void backToUserPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml", userBean,null);
    }

    @FXML
    private void goToClubOwnerPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage1.fxml", null, clubOwnerBean);
    }

    public void setAll(UserBean userBean, EventBean eventBean, String oldInput) throws SQLException {
        this.userBean = userBean;
        this.eventBean = eventBean;
        this.oldInput = oldInput;
        this.buttonUsername.setText(eventBean.getName());
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
            this.listView.getItems().add(pane);
        }

    }

}