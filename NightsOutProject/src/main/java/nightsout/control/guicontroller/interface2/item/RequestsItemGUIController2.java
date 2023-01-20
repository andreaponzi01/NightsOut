package nightsout.control.guicontroller.interface2.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.SwitchAndSetPage2;

import java.time.format.DateTimeFormatter;

public class RequestsItemGUIController2 {

    @FXML
    private Label labelEventName;
    @FXML
    private Label labelEventDate;
    @FXML
    private ImageView userImageView;
    private SwitchAndSetPage2 switchAndSetPage2 = new SwitchAndSetPage2();
    private EventBean2 eventBean;

    public void setAll(RequestBean requestBean) throws SystemException {

        JoinEventAppController controller = new JoinEventAppController();
        this.eventBean = new EventBean2(controller.searchEventByIdEvent(requestBean.getIdEvent()));
        this.labelEventName.setText(String.valueOf(eventBean.getName()));
        this.userImageView.setImage(new Image(eventBean.getImg().toURI().toString()));
        this.labelEventDate.setText(requestBean.getRequestDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
    }

    @FXML
    private void goToEventPage(ActionEvent actionEvent) {

        try {
            switchAndSetPage2.switchAndSetSceneEvent(actionEvent, "/EventPageFromUser2.fxml", this.eventBean);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
