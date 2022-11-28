package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;

public class ViewCreatedEventItemGUIController1 {

    private UserBean userBean;
    private ClubOwnerBean clubOwnerBean;
    private EventBean eventBean;
    private String oldFxml;
    private String prevOldFxml;
    @FXML
    Label labelEventName;

    public void setAll(UserBean userBean, ClubOwnerBean clubOwnerBean, EventBean eventBean, String oldFxml, String prevOldFxml) {
        this.userBean = userBean;
        this.clubOwnerBean = clubOwnerBean;
        this.eventBean = eventBean;
        this.prevOldFxml = prevOldFxml;
        this.oldFxml = oldFxml;
        labelEventName.setText(this.eventBean.getName());
    }


    public void goToEventPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneEvent2(actionEvent, "/EventPageDecorator1.fxml",  userBean, clubOwnerBean, eventBean, oldFxml, prevOldFxml);
    }
}