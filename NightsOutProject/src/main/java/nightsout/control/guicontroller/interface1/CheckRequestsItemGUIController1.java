package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

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

    private EventBean eventBean;

    public void setAll(RequestBean requestBean, EventBean eventBean) {

        this.eventBean = eventBean;
        this.labelEventName.setText(String.valueOf(eventBean.getName()));
        this.buttonStatus.setText(requestBean.getStatus());
        this.userImageView.setImage(new Image(eventBean.getImg().toURI().toString()));
        this.labelEventDate.setText(requestBean.getRequestDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
    }

    @FXML
    private void goToEventPage(ActionEvent actionEvent) {

        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneEventUser(actionEvent, "/EventPageDecoratorUser1.fxml", this.eventBean);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

}
