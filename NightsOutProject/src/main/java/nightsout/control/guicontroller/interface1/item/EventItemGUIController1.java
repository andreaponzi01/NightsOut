package nightsout.control.guicontroller.interface1.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.utils.Session;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchAndSetPage1;

public class EventItemGUIController1 {

    private EventBean1 eventBean1;
    private SwitchAndSetPage1 switchAndSetPage1 = new SwitchAndSetPage1();
    private JoinEventAppController joinEventAppController;
    @FXML
    private Label labelEventName;
    @FXML
    private ImageView imageViewProfilePic;

    public void setAll(EventBean1 eventBean1) {

        this.eventBean1 = eventBean1;
        labelEventName.setText(this.eventBean1.getName());
        imageViewProfilePic.setImage(new Image(this.eventBean1.getImg().toURI().toString()));

    }

    public void setAll(EventBean1 eventBean1, JoinEventAppController joinEventAppController) {

        this.eventBean1 = eventBean1;
        this.joinEventAppController = joinEventAppController;
        labelEventName.setText(this.eventBean1.getName());
        imageViewProfilePic.setImage(new Image(this.eventBean1.getImg().toURI().toString()));

    }

    @FXML
    public void goToEventPage(ActionEvent actionEvent) {
        try {
            String type = Session.getInstance().checkInstanceType();
            if(type.equalsIgnoreCase("Free")){
                switchAndSetPage1.switchAndSetSceneEvent(actionEvent, "/EventPageDecoratorUser1.fxml", eventBean1,  this.joinEventAppController);
            }
            else{
                switchAndSetPage1.switchAndSetSceneEvent(actionEvent, "/EventPageDecoratorCO1.fxml", eventBean1);
            }
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
