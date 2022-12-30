package nightsout.control.guicontroller.interface1.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.LoggedClubOwnerBean1;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage1;

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
            SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
            String type = LoggedClubOwnerBean1.checkInstanceType();
            if (type.equals("FREE")) {
                replacer.switchAndSetSceneEvent(actionEvent, "/EventPageDecoratorUser1.fxml", eventBean1);
            } else {
                replacer.switchAndSetSceneEvent(actionEvent, "/EventPageDecoratorCO1.fxml", eventBean1);
            }
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }
}