package nightsout.control.guicontroller.interface2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.LoggedClubOwnerBean2;
import nightsout.utils.scene.ReplaceSceneDynamic1;

public class EventItemGUIController2 {

    private EventBean eventBean;
    @FXML
    Label labelEventName;
    @FXML
    ImageView imageViewProfilePic;

    public void setAll(EventBean eventBean) {

        this.eventBean = eventBean;
        labelEventName.setText(this.eventBean.getName());
        imageViewProfilePic.setImage(new Image(this.eventBean.getImg().toURI().toString()));
    }

    public void goToEventPage(ActionEvent actionEvent) {

        // Rimettere try-catch dopo aver implementato le pagine dell'evento

        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        String type = LoggedClubOwnerBean2.checkInstanceType();
        if(type.equals("FREE")){
            //replacer.switchAndSetSceneEventUser(actionEvent, "/EventPageDecoratorUser1.fxml", eventBean);
        }
        else{
            //replacer.switchAndSetSceneEventCO(actionEvent, "/EventPageDecoratorCO1.fxml", eventBean);
        }
    }
}
