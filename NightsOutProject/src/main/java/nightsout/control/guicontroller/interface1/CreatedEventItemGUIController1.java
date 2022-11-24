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

    private UserBean userBean;
    private ClubOwnerBean clubOwnerBean;
    private EventBean eventBean;
    private String oldFxml;
    private String prevOldFxml;
    @FXML
    Label labelEventName;

    public void setAll(ClubOwnerBean clubOwnerBean, EventBean eventBean, String oldFxml) {
        this.clubOwnerBean=clubOwnerBean;
        this.eventBean=eventBean;
        this.oldFxml = oldFxml;
        labelEventName.setText(this.eventBean.getName());
    }

    public void setAllView(UserBean userBean, ClubOwnerBean clubOwnerBean, EventBean eventBean, String oldFxml, String prevOldFxml) {
        this.userBean = userBean;
        this.clubOwnerBean = clubOwnerBean;
        this.eventBean = eventBean;
        this.prevOldFxml = prevOldFxml;
        System.out.println(prevOldFxml);
        this.oldFxml = oldFxml;
        labelEventName.setText(this.eventBean.getName());
    }


    public void goToEventPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        System.out.println(oldFxml);
        if (oldFxml.equals("/ClubOwnerPage1.fxml"))
            replacer.switchAndSetSceneEvent(actionEvent, "/EventPageDecorator1.fxml",  clubOwnerBean, eventBean, oldFxml);
        else if (oldFxml.equals("/ViewClubOwnerPage1.fxml")) {
            replacer.switchAndSetSceneEvent2(actionEvent, "/EventPageDecorator1.fxml",  userBean, clubOwnerBean, eventBean, oldFxml, prevOldFxml);
        }
    }
}
