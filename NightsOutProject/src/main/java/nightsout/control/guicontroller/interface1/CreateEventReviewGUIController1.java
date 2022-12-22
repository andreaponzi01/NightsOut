package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import nightsout.control.appcontroller.CreateEventReviewAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.LoggedUserBean1;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

public class CreateEventReviewGUIController1 {

    private EventBean1 eventBean1;
    private UserBean1 userBean1;
    @FXML
    private Label labelEventName;
    @FXML
    private TextArea textFieldReview;
    @FXML
    private MenuUserGUIController1 menuController;


    public CreateEventReviewGUIController1() {
        //ignore
    }

    public void setAll(EventBean1 eventBean1) {

        this.userBean1 = LoggedUserBean1.getInstance();
        this.eventBean1 = eventBean1;
        this.labelEventName.setText(eventBean1.getName());
    }

    public void createReview(ActionEvent actionEvent) {

        try {
            ReviewBean reviewBean= new ReviewBean();
            reviewBean.setComment(textFieldReview.getText());
            reviewBean.setIdUser(userBean1.getId());
            reviewBean.setIdEvent(eventBean1.getIdEvent());
            CreateEventReviewAppController.createEventReview(reviewBean);
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml");
        } catch (SystemException | EmptyInputException e) {
            MyNotification.createNotification(e);
        }
    }

    public void backToEndedBookedEventsPage(ActionEvent actionEvent) {

        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneEndedBookedEvents(actionEvent, "/EndedBookedEventsPage1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

}
