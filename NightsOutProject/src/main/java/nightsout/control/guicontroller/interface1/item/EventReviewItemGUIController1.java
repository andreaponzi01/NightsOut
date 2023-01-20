package nightsout.control.guicontroller.interface1.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.appcontroller.ManageReviewAppController;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.SwitchAndSetPage1;

public class EventReviewItemGUIController1 {

    private EventBean1 eventBean1;
    private SwitchAndSetPage1 switchAndSetPage1 = new SwitchAndSetPage1();
    @FXML
    private Label labelEventName;
    @FXML
    private ImageView imageViewEvent;
    private ManageReviewAppController manageReviewAppController;

    public void setAll(EventBean1 eventBean1, ManageReviewAppController manageReviewAppController) {

        this.eventBean1 = eventBean1;
        this.manageReviewAppController = manageReviewAppController;
        this.labelEventName.setText(this.eventBean1.getName());
        this.imageViewEvent.setImage(new Image(eventBean1.getImg().toURI().toString()));
    }
    @FXML
    private void goToEventPage(ActionEvent actionEvent) {

      try {
          switchAndSetPage1.switchAndSetSceneEvent(actionEvent, "/EventPageDecoratorUser1.fxml", eventBean1);
      } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
    @FXML
    private void goToReviewPage(ActionEvent actionEvent) {

        try {
            switchAndSetPage1.switchAndSetSceneEvent(actionEvent, "/CreateEventReviewPage1.fxml", eventBean1, manageReviewAppController);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
