package nightsout.control.guicontroller.interface2.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import nightsout.control.appcontroller.EventReviewsClubOwnerAppController;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.myexception.SystemException;

public class ReviewItemToResponseGUIController2 {

    @FXML
    public Button buttonUsername;
    private UserBean2 userBean;
    private ReviewBean reviewBean;

    public ReviewItemToResponseGUIController2() {
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
            this.userBean = new UserBean2(EventReviewsClubOwnerAppController.searchUserbyIdUser(reviewBean.getIdUser()));
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
        EventBean eventBean = EventReviewsClubOwnerAppController.searchEventbyIdEvent(reviewBean.getIdEvent());
        this.buttonUsername.setText(userBean.getUsername());
        this.labelEventName.setText(eventBean.getName());
    }

    public void goToResponsePage(ActionEvent actionEvent) {
/*
        try {
            //SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
            //replacer.switchAndSetSceneMakeResponse(actionEvent, "/MakeResponsePage1.fxml", userBean, reviewBean);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }

 */
    }

    public void goToUserPage(ActionEvent actionEvent) {
/*
        try {
            SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
            replacer.switchAndSetSceneUser(actionEvent,"/ViewUserPageFromCO1.fxml",userBean);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
        */

    }


}
