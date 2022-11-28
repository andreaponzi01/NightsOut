package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;

public class CreatedEventItemGUIController1 {

    private ClubOwnerBean clubOwnerBean;
    private EventBean eventBean;
    private String oldFxml;
    @FXML
    Label labelEventName;

    public void setAll(ClubOwnerBean clubOwnerBean, EventBean eventBean, String oldFxml) {
        this.clubOwnerBean=clubOwnerBean;
        this.eventBean=eventBean;
        this.oldFxml = oldFxml;
        labelEventName.setText(this.eventBean.getName());
    }


    public void goToEventPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneEvent(actionEvent, "/EventPageDecorator1.fxml",  clubOwnerBean, eventBean, oldFxml);
    }
}
