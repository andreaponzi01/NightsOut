package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.control.appcontroller.RequestAppController;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scenes.ReplaceSceneDynamic1;

import java.io.IOException;
import java.util.Objects;

public class EventItemGUIController1 {

    private UserBean userBean;
    private EventBean eventBean;
    private String input;

    @FXML
    Label labelEventName;

    @FXML
    private void goToEventPage(ActionEvent actionEvent) throws IOException {
        RequestBean requestBean = RequestAppController.checkRequestStatus(userBean, eventBean);
        if(Objects.equals(requestBean.getStatus(), null)) {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneEvent(actionEvent, "/EventPageSendRequest1.fxml", eventBean, userBean, input);
        } else if(Objects.equals(requestBean.getStatus(), "pending")) {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneEvent(actionEvent, "/EventPageAlreadySentRequest1.fxml", eventBean, userBean, input);
        }
    }

    public void setAll(UserBean userBean, EventBean eventBean, String oldInput) {
        this.userBean = userBean;
        this.eventBean = eventBean;
        this.input = oldInput;
        labelEventName.setText(this.eventBean.getName());
    }
}
