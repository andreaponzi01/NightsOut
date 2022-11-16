package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import nightsout.control.appcontroller.EventPageAppController;
import nightsout.control.appcontroller.RequestAppController;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EventPageSendRequestGUIController1 {

    private UserBean userBean;
    private EventBean eventBean;
    private String oldInput;

    @FXML
    Button buttonUsername;
    @FXML
    Button buttonSendRequest;
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
    private void backToSearchPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneOldSearch(actionEvent, "/SearchPage1.fxml", userBean, oldInput);
    }

    @FXML
    private void sendRequest(ActionEvent actionEvent) throws IOException {
        RequestAppController.sendRequest(userBean, eventBean);
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneEvent(actionEvent, "/EventPagePendingRequest1.fxml", eventBean, userBean, oldInput);
    }

    @FXML
    private void goToClubOwnerPage(ActionEvent actionEvent) throws IOException {
        ClubOwnerBean clubOwnerBean= EventPageAppController.getClubOwner(eventBean.getIdClubOwner());
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage1.fxml", null, clubOwnerBean);
    }


    public void setAll(UserBean userBean, EventBean eventBean, String oldInput) {
        this.userBean = userBean;
        this.eventBean = eventBean;
        this.oldInput = oldInput;
        this.buttonUsername.setText(eventBean.getName());
        this.labelEventName.setText(eventBean.getName());
        this.labelEventPrice.setText(String.valueOf(eventBean.getPrice()));
        this.labelEventDate.setText(String.valueOf(eventBean.getEventDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy"))));
        this.labelEventDuration.setText(String.valueOf(eventBean.getDuration()));
        this.labelEventTime.setText(String.valueOf(LocalTime.of(eventBean.getHours(), eventBean.getMinutes()).toString()));
    }

}
