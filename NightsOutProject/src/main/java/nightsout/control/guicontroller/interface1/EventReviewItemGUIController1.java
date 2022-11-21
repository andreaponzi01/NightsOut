package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;

public class EventReviewItemGUIController1 {

    private UserBean userBean;
    private EventBean eventBean;

    @FXML
    Label labelEventName;

    @FXML
    private void goToEventPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneEvent(actionEvent, "/EventPageDecorator1.fxml", userBean, eventBean, "/UserPage1.fxml");
    }

    @FXML
    private void goToReviewPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneCreateEventReview(actionEvent, "/CreateEventReviewPage1.fxml", eventBean, userBean);
    }

    public void setAll(UserBean userBean, EventBean eventBean) {
        this.userBean = userBean;
        this.eventBean = eventBean;
        labelEventName.setText(this.eventBean.getName());
    }

}
