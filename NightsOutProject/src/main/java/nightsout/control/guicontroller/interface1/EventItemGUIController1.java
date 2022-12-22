package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.LoggedClubOwnerBean1;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

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

    public void goToEventPage(ActionEvent actionEvent) {
        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            String type = LoggedClubOwnerBean1.checkInstanceType();
            if(type.equals("FREE")){
                replacer.switchAndSetSceneEventUser(actionEvent, "/EventPageDecoratorUser1.fxml", eventBean1);
            }
            else{
                replacer.switchAndSetSceneEventCO(actionEvent, "/EventPageDecoratorCO1.fxml", eventBean1);
            }
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }
}
