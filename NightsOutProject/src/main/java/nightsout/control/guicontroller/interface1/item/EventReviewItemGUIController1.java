package nightsout.control.guicontroller.interface1.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage1;

public class EventReviewItemGUIController1 {

    private EventBean1 eventBean1;
    @FXML
    private Label labelEventName;

    @FXML
    private ImageView imageViewEvent;

    public void setAll(EventBean1 eventBean1) {

        this.eventBean1 = eventBean1;
        this.labelEventName.setText(this.eventBean1.getName());
        this.imageViewEvent.setImage(new Image(eventBean1.getImg().toURI().toString()));
    }
    @FXML
    private void goToEventPage(ActionEvent actionEvent) {

      try {
          SwitchAndSetPage1.switchAndSetSceneEvent(actionEvent, "/EventPageDecoratorUser1.fxml", eventBean1);
      } catch (SystemException e) {
            ExceptionHandler.handleException(e);
        }
    }
    @FXML
    private void goToReviewPage(ActionEvent actionEvent) {

        try {
            SwitchAndSetPage1.switchAndSetSceneEvent(actionEvent, "/CreateEventReviewPage1.fxml", eventBean1);
        } catch (SystemException e) {
            ExceptionHandler.handleException(e);
        }
    }
}
