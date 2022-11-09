package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scenes.ReplaceSceneDynamic1;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EventPageAlreadySentRequestGUIController1 {

    private UserBean userBean;
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
    private void backToSearchPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneOldSearch(actionEvent, "/SearchPage1.fxml", userBean, oldInput);
    }

    @FXML
    private void goToClubOwnerPage(ActionEvent actionEvent) {

    }

    public void setAll(UserBean userBean, EventBean eventBean, String oldInput) {
        this.userBean = userBean;
        this.eventBean = eventBean;
        this.oldInput = oldInput;
        this.labelEventName.setText(eventBean.getName());
        this.labelEventPrice.setText(String.valueOf(eventBean.getPrice()));
        this.labelEventDate.setText(String.valueOf(eventBean.getEventDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy"))));
        this.labelEventDuration.setText(String.valueOf(eventBean.getDuration()));
        this.labelEventTime.setText(String.valueOf(LocalTime.of(eventBean.getHours(), eventBean.getMinutes()).toString()));
    }

}