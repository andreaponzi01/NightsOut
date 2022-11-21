package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ProfileBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;

public class EventItemGUIController1 {

    private ProfileBean bean;
    private EventBean eventBean;
    private String oldFxml;

    @FXML
    Label labelEventName;

    @FXML
    private void goToEventPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneEvent(actionEvent, "/EventPageDecorator1.fxml", bean, eventBean, oldFxml);
    }

    public void setAll(ProfileBean bean, EventBean eventBean, String oldFxml) {
        this.bean = bean;
        this.eventBean = eventBean;
        this.oldFxml = oldFxml;
        labelEventName.setText(this.eventBean.getName());
    }
}
