package nightsout.control.guicontroller.interface1.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.utils.bean.LoggedBean;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage1;

public class EventItemGUIController1 {

    private EventBean1 eventBean1;
    @FXML
    Label labelEventName;
    @FXML
    ImageView imageViewProfilePic;

    public void setAll(EventBean1 eventBean1) {

        this.eventBean1 = eventBean1;
        labelEventName.setText(this.eventBean1.getName());
        imageViewProfilePic.setImage(new Image(this.eventBean1.getImg().toURI().toString()));
    }

    @FXML
    public void goToEventPage(ActionEvent actionEvent) {
        try {
            String type = LoggedBean.getInstance().checkInstanceType();
            if(type.equalsIgnoreCase("Free")){
                SwitchAndSetPage1.switchAndSetSceneEvent(actionEvent, "/EventPageDecoratorUser1.fxml", eventBean1);
            }
            else{
                SwitchAndSetPage1.switchAndSetSceneEvent(actionEvent, "/EventPageDecoratorCO1.fxml", eventBean1);
            }
        } catch (SystemException e) {
            ExceptionHandler.handleException(e);
        }
    }
}
