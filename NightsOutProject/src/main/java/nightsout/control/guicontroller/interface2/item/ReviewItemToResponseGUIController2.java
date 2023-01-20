package nightsout.control.guicontroller.interface2.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import nightsout.control.appcontroller.ManageReviewAppController;
import nightsout.utils.bean.EventBean;
import nightsout.utils.Session;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.SwitchAndSetPage2;
import nightsout.utils.scene.SwitchPage;

public class ReviewItemToResponseGUIController2 {

    @FXML
    private Label labelUsername;
    private UserBean2 userBean;
    private ReviewBean reviewBean;
    @FXML
    private TextArea textAreaResponse;
    @FXML
    private Label labelEventName;
    @FXML
    private Label labelComment;

    private SwitchPage switchPage = new SwitchPage();
    private SwitchAndSetPage2 switchAndSetPage2 = new SwitchAndSetPage2();
    private ManageReviewAppController manageReviewAppController;

    public void setAll(ReviewBean reviewBean, ManageReviewAppController manageReviewAppController) throws SystemException {

        this.manageReviewAppController = manageReviewAppController;
        this.reviewBean = reviewBean;
        this.labelComment.setText(reviewBean.getComment());
        try {
            this.userBean = new UserBean2(manageReviewAppController.searchUserbyIdUser(reviewBean.getIdUser()));
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
        EventBean eventBean = manageReviewAppController.searchEventbyIdEvent(reviewBean.getIdEvent());
        this.labelUsername.setText(userBean.getUsername());
        this.labelEventName.setText(eventBean.getName());
    }
    @FXML
    public void makeResponse(ActionEvent actionEvent) {

        try {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setResponse(textAreaResponse.getText());
            responseBean.setIdClubOwner(Session.getInstance().getClubOwner().getId());
            responseBean.setReview(reviewBean.getIdReview());
            manageReviewAppController.makeResponse(responseBean);
            switchPage.replaceScene(actionEvent,"/ReviewsAndMakeResponsePage2.fxml");
        } catch (SystemException | EmptyInputException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    public void goToUserPage(ActionEvent actionEvent) {
        try {
            switchAndSetPage2.switchAndSetSceneUser(actionEvent,"/ViewUserPageFromCO2.fxml",userBean);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
