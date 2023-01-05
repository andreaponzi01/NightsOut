package nightsout.control.guicontroller.interface2.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.appcontroller.MakeReviewAppController;
import nightsout.utils.bean.interface2.LoggedUserBean2;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.*;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage2;
import nightsout.utils.scene.switchpage.SwitchPage;

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
            CreateNotification.createNotification(e);
      }
    }
    public void sendReview(ActionEvent actionEvent) {

        try {
            ReviewBean reviewBean= new ReviewBean();
            reviewBean.setComment(textAreaReview.getText());
            reviewBean.setIdUser(LoggedUserBean2.getInstance().getId());
            reviewBean.setIdEvent(eventBean.getIdEvent());
            MakeReviewAppController.createEventReview(reviewBean);
            SwitchPage.replaceScene(actionEvent,"/UserPage2.fxml");
        } catch (SystemException | EmptyInputException e) {
            CreateNotification.createNotification(e);
        }
    }
}
