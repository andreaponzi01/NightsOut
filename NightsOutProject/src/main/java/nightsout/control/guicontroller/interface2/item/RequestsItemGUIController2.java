package nightsout.control.guicontroller.interface2.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage2;

import java.time.format.DateTimeFormatter;

public class RequestsItemGUIController2 {

    @FXML
    Label labelEventName;
    @FXML
    Label labelEventDate;
    @FXML
    ImageView userImageView;

    private EventBean2 eventBean;

    public void setAll(RequestBean requestBean) throws SystemException {

        this.eventBean = new EventBean2(JoinEventAppController.searchEventByIdEvent(requestBean.getIdEvent()));
        this.labelEventName.setText(String.valueOf(eventBean.getName()));
        this.userImageView.setImage(new Image(eventBean.getImg().toURI().toString()));
        this.labelEventDate.setText(requestBean.getRequestDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
    }

    @FXML
    private void goToEventPage(ActionEvent actionEvent) {

        try {
            SwitchAndSetPage2.switchAndSetSceneEvent(actionEvent, "/EventPageFromUser2.fxml", this.eventBean);
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }
}
