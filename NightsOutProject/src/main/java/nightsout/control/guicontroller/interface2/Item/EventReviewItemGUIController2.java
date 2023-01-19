package nightsout.control.guicontroller.interface2.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.appcontroller.ManageReviewAppController;
import nightsout.utils.Session;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.exception.ErrorDialog;
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
    private SwitchPage switchPage = new SwitchPage();
    private SwitchAndSetPage2 switchAndSetPage2 = new SwitchAndSetPage2();

    public void setAll(EventBean2 eventBean) {

        this.eventBean = eventBean;
        this.labelEventName.setText(this.eventBean.getName());
        this.imageViewEvent.setImage(new Image(eventBean.getImg().toURI().toString()));
    }

    @FXML
    private void goToEventPage(ActionEvent actionEvent) {

      try {
          switchAndSetPage2.switchAndSetSceneEvent(actionEvent, "/EventPageFromUser2.fxml", eventBean);
      } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
      }
    }
    public void sendReview(ActionEvent actionEvent) {

        ManageReviewAppController controller;

        try {
            controller = new ManageReviewAppController();
            ReviewBean reviewBean= new ReviewBean();
            reviewBean.setComment(textAreaReview.getText());
            reviewBean.setIdUser(Session.getInstance().getUser().getId());
            reviewBean.setIdEvent(eventBean.getIdEvent());
            controller.createEventReview(reviewBean);
            switchPage.replaceScene(actionEvent,"/UserPage2.fxml");
        } catch (SystemException | EmptyInputException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
