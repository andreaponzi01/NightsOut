package nightsout.control.guicontroller.interface2.Item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.guicontroller.MyNotification;


import nightsout.utils.bean.LoggedClubOwnerBean2;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.exception.myexception.SystemException;

import nightsout.utils.scene.switchPage.SwitchAndSetPage2;

public class EventItemGUIController2 {

    private EventBean2 eventBean;
    @FXML
    Label labelEventName;
    @FXML
    ImageView imageViewProfilePic;

    public void setAll(EventBean2 eventBean) {
        this.eventBean=eventBean;
        labelEventName.setText(this.eventBean.getName());
        imageViewProfilePic.setImage(new Image(this.eventBean.getImg().toURI().toString()));
    }

    public void goToEventPage(ActionEvent actionEvent) {
        try {
            SwitchAndSetPage2 replacer = new SwitchAndSetPage2();
            String type = LoggedClubOwnerBean2.checkInstanceType();
            if(type.equals("FREE")){
                replacer.switchAndSetSceneEvent(actionEvent, "/EventPageFromUser2.fxml", eventBean);
            }
            else{
                replacer.switchAndSetSceneEvent(actionEvent, "/EventPageFromCO2.fxml", eventBean);
            }
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }
}