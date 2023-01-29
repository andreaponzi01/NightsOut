package nightsout.control.guicontroller.interface2.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.utils.Session;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchAndSetPage2;

public class EventItemGUIController2 {

    private EventBean2 eventBean;
    @FXML
    private Label labelEventName;
    @FXML
    private ImageView imageViewProfilePic;

    private SwitchAndSetPage2 switchAndSetPage2 = new SwitchAndSetPage2();
    private JoinEventAppController joinEventAppController;

    public void setAll(EventBean2 eventBean) {

        this.eventBean=eventBean;
        labelEventName.setText(this.eventBean.getName());
        imageViewProfilePic.setImage(new Image(this.eventBean.getImg().toURI().toString()));
    }

    public void setAll(EventBean2 eventBean, JoinEventAppController joinEventAppController) {

        this.joinEventAppController = joinEventAppController;
        setAll(eventBean);
    }

    @FXML
    private void goToEventPage(ActionEvent actionEvent) {
        try {
            String type = Session.getInstance().checkInstanceType();
            if(type.equalsIgnoreCase("FREE")){
                switchAndSetPage2.switchAndSetSceneEvent(actionEvent, "/EventPageFromUser2.fxml", eventBean, joinEventAppController);
            }
            else{
                switchAndSetPage2.switchAndSetSceneEvent(actionEvent, "/EventPageFromCO2.fxml", eventBean);
            }
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}