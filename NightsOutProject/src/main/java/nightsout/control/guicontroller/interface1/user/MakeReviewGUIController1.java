package nightsout.control.guicontroller.interface1.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import nightsout.control.appcontroller.MakeReviewAppController;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.LoggedUserBean1;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchPage;

public class MakeReviewGUIController1 {

    private EventBean1 eventBean1;
    private UserBean1 userBean1;
    @FXML
    private Label labelEventName;
    @FXML
    private TextArea textAreaReview;

    private MakeReviewGUIController1() {
        // ignored
    }

    public void setAll(EventBean1 eventBean1) {

        this.userBean1 = LoggedUserBean1.getInstance();
        this.eventBean1 = eventBean1;
        this.labelEventName.setText(eventBean1.getName());
    }
    public void createReview(ActionEvent actionEvent) {

        try {
            ReviewBean reviewBean= new ReviewBean();
            reviewBean.setComment(textAreaReview.getText());
            reviewBean.setIdUser(userBean1.getId());
            reviewBean.setIdEvent(eventBean1.getIdEvent());
            MakeReviewAppController.createEventReview(reviewBean);
            SwitchPage.replaceScene(actionEvent,"/UserPage1.fxml");
        } catch (SystemException | EmptyInputException e) {
            CreateNotification.createNotification(e);
        }
    }
    public void backToEndedBookedEventsPage(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent,"/EndedBookedEventsPage1.fxml");}
}
