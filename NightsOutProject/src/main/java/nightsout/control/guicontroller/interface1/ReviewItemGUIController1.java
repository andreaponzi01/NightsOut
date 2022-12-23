package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import nightsout.control.appcontroller.EventReviewsClubOwnerAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchPage.SwitchAndSetPage1;

public class ReviewItemGUIController1 {

    @FXML
    public Button buttonUsername;
    private UserBean1 userBean1;
    private ReviewBean reviewBean;

    public ReviewItemGUIController1() {
        //ignore
    }

    @FXML
    private Label labelComment;
    @FXML
    private Label labelEventName;

    public void setAll(ReviewBean reviewBean) throws SystemException {
        this.reviewBean = reviewBean;
        this.labelComment.setText(reviewBean.getComment());
        try {
            this.userBean1 = new UserBean1(EventReviewsClubOwnerAppController.searchUserbyIdUser(reviewBean.getIdUser()));

        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
        EventBean eventBean = EventReviewsClubOwnerAppController.searchEventbyIdEvent(reviewBean.getIdEvent());
        this.buttonUsername.setText(userBean1.getUsername());
        this.labelEventName.setText(eventBean.getName());
    }

    public void goToResponsePage(ActionEvent actionEvent) {

        try {
            SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
            replacer.switchAndSetSceneMakeResponse(actionEvent, "/MakeResponsePage1.fxml", userBean1, reviewBean);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    public void goToUserPage(ActionEvent actionEvent) {

        try {
            SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
            replacer.switchAndSetSceneUser(actionEvent,"/ViewUserPageFromCO1.fxml",userBean1);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }
}
