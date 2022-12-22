package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.LoggedClubOwnerBean1;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

public class ViewCreatedEventItemGUIController1 {

    private EventBean1 eventBean1;
    @FXML
    Label labelEventName;

    public void setAll(EventBean1 eventBean1) {

        this.eventBean1 = eventBean1;
        labelEventName.setText(this.eventBean1.getName());
    }


    public void goToEventPage(ActionEvent actionEvent) {

        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            String type = LoggedClubOwnerBean1.checkInstanceType();
            if (type.equals("FREE")) {
                replacer.switchAndSetSceneEventUser(actionEvent, "/EventPageDecoratorUser1.fxml", eventBean1);
            } else {
                replacer.switchAndSetSceneEventCO(actionEvent, "/EventPageDecoratorCO1.fxml", eventBean1);
            }
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }
}