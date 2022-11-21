package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;

public class NextEventItemGUIController1 {

    private UserBean userBean;

    private EventBean eventBean;
    @FXML
    Label labelEventName;

    public void setAll(UserBean userBean, EventBean eventBean) {
        this.userBean=userBean;
        this.eventBean=eventBean;
        labelEventName.setText(this.eventBean.getName());
    }
    public void goToEventPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();

        // Da rivedere oldFxml
        replacer.switchAndSetSceneEvent(actionEvent, "/EventPageDecorator1.fxml",  userBean, eventBean, "/UserPage1.fxml");
    }
}
