package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import nightsout.control.appcontroller.EventReviewsClubOwnerAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;

public class ReviewItemGUIController1 {

    @FXML
    public Button buttonUsername;
    private UserBean userBean;
    private ReviewBean reviewBean;

    public ReviewItemGUIController1() {
        //ignore
    }

    @FXML
    private Label labelComment;
    @FXML
    private Label labelEventName;

    public void setAll(ReviewBean reviewBean) throws SQLException, SystemException {
        this.reviewBean=reviewBean;
        this.labelComment.setText(reviewBean.getComment());
        try {
            this.userBean = EventReviewsClubOwnerAppController.searchUserbyIdUser(reviewBean.getIdUser());

        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
        EventBean eventBean=EventReviewsClubOwnerAppController.searchEventbyIdEvent(reviewBean.getIdEvent());
        this.buttonUsername.setText(userBean.getUsername());
        this.labelEventName.setText(eventBean.getName());
    }

    public void goToResponsePage(ActionEvent actionEvent) throws IOException {
        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneMakeResponse(actionEvent, "/MakeResponsePage1.fxml", userBean, reviewBean);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    public void goToUserPage(ActionEvent actionEvent) throws IOException, SQLException {
        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneViewUserPageFromCO(actionEvent,"/ViewUserPageFromCO1.fxml",userBean);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }
}
