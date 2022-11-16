package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;

public class CreatedEventItemGUIController1 {

    private ClubOwnerBean clubOwnerBean;

    private EventBean eventBean;
    @FXML
    Label labelEventName;

    public void setAll(ClubOwnerBean clubOwnerBean, EventBean eventBean) {
        this.clubOwnerBean=clubOwnerBean;
        this.eventBean=eventBean;
        labelEventName.setText(this.eventBean.getName());
    }
    public void goToEventPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneCreatedEvents(actionEvent, "/EventPageClubOwner1.fxml",  clubOwnerBean, eventBean);
    }
}
