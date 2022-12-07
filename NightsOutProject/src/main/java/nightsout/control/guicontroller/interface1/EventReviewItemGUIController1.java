package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.EventBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

public class EventReviewItemGUIController1 {

    private EventBean eventBean;
    @FXML
    private Label labelEventName;

    @FXML
    private ImageView imageViewEvent;

    @FXML
    private void goToEventPage(ActionEvent actionEvent) {

      try {
          ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
          replacer.switchAndSetSceneEventUser(actionEvent, "/EventPageDecoratorUser1.fxml", eventBean);
      } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    @FXML
    private void goToReviewPage(ActionEvent actionEvent) {

        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneCreateEventReview(actionEvent, "/CreateEventReviewPage1.fxml", eventBean);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    public void setAll(EventBean eventBean) {

        this.eventBean = eventBean;
        this.labelEventName.setText(this.eventBean.getName());
        this.imageViewEvent.setImage(new Image(eventBean.getImg().toURI().toString()));
    }

}
