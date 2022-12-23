package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchPage.SwitchAndSetPage1;

import java.time.format.DateTimeFormatter;

public class CheckRequestsItemGUIController1 {

    @FXML
    Label labelEventName;
    @FXML
    Label labelEventDate;
    @FXML
    Button buttonStatus;
    @FXML
    ImageView userImageView;

    private EventBean1 eventBean1;

    public void setAll(RequestBean requestBean, EventBean1 eventBean1) {

        this.eventBean1 = eventBean1;
        this.labelEventName.setText(String.valueOf(eventBean1.getName()));
        this.buttonStatus.setText(requestBean.getStatus());
        this.userImageView.setImage(new Image(eventBean1.getImg().toURI().toString()));
        this.labelEventDate.setText(requestBean.getRequestDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
    }

    @FXML
    private void goToEventPage(ActionEvent actionEvent) {

        try {
            SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
            replacer.switchAndSetSceneEvent(actionEvent, "/EventPageDecoratorUser1.fxml", this.eventBean1);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

}
