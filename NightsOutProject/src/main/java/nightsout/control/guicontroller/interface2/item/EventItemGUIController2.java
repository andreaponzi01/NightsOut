package nightsout.control.guicontroller.interface2.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.utils.exception.CreateNotification;


import nightsout.utils.bean.interface2.LoggedClubOwnerBean2;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.exception.myexception.SystemException;

import nightsout.utils.scene.switchpage.SwitchAndSetPage2;

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
            CreateNotification.createNotification(e);
        }
    }
}