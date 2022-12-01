package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nightsout.control.appcontroller.CreateEventReviewAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.LoggedUserBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;

public class CreateEventReviewGUIController1 {

    private EventBean eventBean;
    private ReviewBean reviewBean;
    private UserBean userBean;
    @FXML
    private Label labelEventName;
    @FXML
    private TextField textFieldReview;
    @FXML
    private MenuUserGUIController1 menuController;


    public CreateEventReviewGUIController1() {
        //ignore
    }

    public void setAll(EventBean eventBean) throws SQLException {
        this.userBean= LoggedUserBean.getInstance();
        this.eventBean=eventBean;
        this.menuController.setAll();
        this.labelEventName.setText(eventBean.getName());
    }

    public void createReview(ActionEvent actionEvent) throws IOException {

        if(!textFieldReview.getText().isBlank())
        {
            try {
                reviewBean= new ReviewBean();
                reviewBean.setComment(textFieldReview.getText());
                reviewBean.setIdUser(userBean.getId());
                reviewBean.setIdEvent(eventBean.getIdEvent());
                CreateEventReviewAppController.createEventReview(reviewBean);
                ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
                replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml");
            } catch (SystemException e) {
                MyNotification.createNotification(e);
            }
        }
        else
        {
            System.out.println("\n\nINSERISCI UN COMMENT IPOCRITA!!!!!\n\n");
        }
    }

    public void backToEndedBookedEventsPage(ActionEvent actionEvent) throws SystemException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneEndedBookedEvents(actionEvent, "/EndedBookedEventsPage1.fxml");
    }

}
