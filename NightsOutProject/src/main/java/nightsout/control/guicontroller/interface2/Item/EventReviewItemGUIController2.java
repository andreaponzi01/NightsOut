package nightsout.control.guicontroller.interface2.Item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.appcontroller.CreateEventReviewAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.*;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchPage.SwitchAndSetPage2;

public class EventReviewItemGUIController2 {

    private EventBean2 eventBean;
    @FXML
    private Label labelEventName;
    @FXML
    private TextArea textAreaReview;

    @FXML
    private ImageView imageViewEvent;

    public void setAll(EventBean2 eventBean) {

        this.eventBean = eventBean;
        this.labelEventName.setText(this.eventBean.getName());
        this.imageViewEvent.setImage(new Image(eventBean.getImg().toURI().toString()));
    }

    @FXML
    private void goToEventPage(ActionEvent actionEvent) {

      try {
          SwitchAndSetPage2 replacer = new SwitchAndSetPage2();
          replacer.switchAndSetSceneEvent(actionEvent, "/EventPageFromUser2.fxml", eventBean);
      } catch (SystemException e) {
            MyNotification.createNotification(e);
      }
    }
    public void sendReview(ActionEvent actionEvent) {

        try {
            ReviewBean reviewBean= new ReviewBean();
            reviewBean.setComment(textAreaReview.getText());
            reviewBean.setIdUser(LoggedUserBean2.getInstance().getId());
            reviewBean.setIdEvent(eventBean.getIdEvent());
            CreateEventReviewAppController.createEventReview(reviewBean);
            SwitchAndSetPage2 replacer = new SwitchAndSetPage2();
            replacer.switchAndSetScene(actionEvent, "/UserPage2.fxml");
        } catch (SystemException | EmptyInputException e) {
            MyNotification.createNotification(e);
        }
    }
}
