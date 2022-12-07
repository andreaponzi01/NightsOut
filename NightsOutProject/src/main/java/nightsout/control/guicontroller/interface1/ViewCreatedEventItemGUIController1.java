package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.LoggedClubOwnerBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

public class ViewCreatedEventItemGUIController1 {

    private EventBean eventBean;
    @FXML
    Label labelEventName;

    public void setAll(EventBean eventBean) {

        this.eventBean = eventBean;
        labelEventName.setText(this.eventBean.getName());
    }


    public void goToEventPage(ActionEvent actionEvent) {

        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            String type = LoggedClubOwnerBean.checkInstanceType();
            if (type.equals("FREE")) {
                replacer.switchAndSetSceneEventUser(actionEvent, "/EventPageDecoratorUser1.fxml", eventBean);
            } else {
                replacer.switchAndSetSceneEventCO(actionEvent, "/EventPageDecoratorCO1.fxml", eventBean);
            }
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }
}