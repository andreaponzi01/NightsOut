package nightsout.control.guicontroller.interface2.Item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.appcontroller.CheckRequestsAppController;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage2;

import java.time.format.DateTimeFormatter;

public class RequestsItemGUIController2 {

    @FXML
    Button buttonEventInfo;
    @FXML
    Label labelEventDate;
    @FXML
    Button buttonStatus;
    @FXML
    ImageView userImageView;

    private EventBean2 eventBean;

    public void setAll(RequestBean requestBean) throws SystemException {

        this.eventBean = new EventBean2(CheckRequestsAppController.searchEventByIdEvent(requestBean.getIdEvent()));
        this.buttonEventInfo.setText(String.valueOf(eventBean.getName()));
        this.buttonStatus.setText(requestBean.getStatus());
        this.userImageView.setImage(new Image(eventBean.getImg().toURI().toString()));
        this.labelEventDate.setText(requestBean.getRequestDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
    }

    @FXML
    private void goToEventPage(ActionEvent actionEvent) {

        try {
            SwitchAndSetPage2 replacer = new SwitchAndSetPage2();
            replacer.switchAndSetSceneEvent(actionEvent, "/EventPageFromUser2.fxml", this.eventBean);
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }
}
