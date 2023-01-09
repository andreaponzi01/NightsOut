package nightsout.control.guicontroller.interface1.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.LoggedBean;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.exception.ExceptionHandler;
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
            String type = LoggedBean.getInstance().checkInstanceType();
            if (type.equalsIgnoreCase("FREE")) {
                SwitchAndSetPage1.switchAndSetSceneEvent(actionEvent, "/EventPageDecoratorUser1.fxml", eventBean1);
            } else {
                SwitchAndSetPage1.switchAndSetSceneEvent(actionEvent, "/EventPageDecoratorCO1.fxml", eventBean1);
            }
        } catch (SystemException e) {
            ExceptionHandler.handleException(e);
        }
    }
}