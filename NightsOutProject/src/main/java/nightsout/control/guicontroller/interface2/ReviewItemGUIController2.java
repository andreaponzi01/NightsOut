package nightsout.control.guicontroller.interface2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nightsout.control.appcontroller.EventReviewsClubOwnerAppController;
import nightsout.control.appcontroller.MakeResponseAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.LoggedClubOwnerBean2;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;
import nightsout.utils.scene.ReplaceSceneDynamic2;

public class ReviewItemGUIController2 {

    @FXML
    public Button buttonUsername;
    private UserBean1 userBean;
    private ReviewBean reviewBean;

    public ReviewItemGUIController2() {
        //ignore
    }

    @FXML
    private Label labelComment;
    @FXML
    private Label labelEventName;
    @FXML
    TextField textFieldResponse;

    public void setAll(ReviewBean reviewBean) throws SystemException {

        this.reviewBean = reviewBean;
        this.labelComment.setText(reviewBean.getComment());
        try {
            this.userBean = EventReviewsClubOwnerAppController.searchUserbyIdUser(reviewBean.getIdUser());

        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
        EventBean eventBean = EventReviewsClubOwnerAppController.searchEventbyIdEvent(reviewBean.getIdEvent());
        this.buttonUsername.setText(userBean.getUsername());
        this.labelEventName.setText(eventBean.getName());
    }

    public void response(ActionEvent actionEvent) {

        try {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setResponse(textFieldResponse.getText());
            responseBean.setIdClubOwner(LoggedClubOwnerBean2.getInstance().getId());
            responseBean.setReview(reviewBean.getIdReview());

            MakeResponseAppController.makeResponse(responseBean);
            ReplaceSceneDynamic2 replacer = new ReplaceSceneDynamic2();
            replacer.switchAndSetScene(actionEvent, "/ReviewsAndMakeResponsePage2.fxml");

        } catch (SystemException | EmptyInputException e) {
            MyNotification.createNotification(e);
        }
    }

    public void goToUserPage(ActionEvent actionEvent) {

        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneViewUserPageFromCO(actionEvent,"/ViewUserPageFromCO1.fxml",userBean);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }
}
