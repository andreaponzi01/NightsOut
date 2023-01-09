package nightsout.control.guicontroller.interface2.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import nightsout.control.appcontroller.EventReviewsClubOwnerAppController;
import nightsout.control.appcontroller.MakeResponseAppController;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.interface2.LoggedClubOwnerBean2;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage1;
import nightsout.utils.scene.switchpage.SwitchAndSetPage2;
import nightsout.utils.scene.switchpage.SwitchPage;

public class ReviewItemToResponseGUIController2 {

    @FXML
    public Label labelUsername;
    private UserBean2 userBean;
    private ReviewBean reviewBean;
    @FXML
    private TextArea textAreaResponse;
    @FXML
    private Label labelEventName;
    @FXML
    private Label labelComment;

    public void setAll(ReviewBean reviewBean) throws SystemException {
        this.reviewBean = reviewBean;
        this.labelComment.setText(reviewBean.getComment());
        try {
            this.userBean = new UserBean2(EventReviewsClubOwnerAppController.searchUserbyIdUser(reviewBean.getIdUser()));
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
        EventBean eventBean = EventReviewsClubOwnerAppController.searchEventbyIdEvent(reviewBean.getIdEvent());
        this.labelUsername.setText(userBean.getUsername());
        this.labelEventName.setText(eventBean.getName());
    }
    @FXML
    public void makeResponse(ActionEvent actionEvent) {
        try {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setResponse(textAreaResponse.getText());
            responseBean.setIdClubOwner(LoggedClubOwnerBean2.getInstance().getId());
            responseBean.setReview(reviewBean.getIdReview());
            MakeResponseAppController.makeResponse(responseBean);
            SwitchPage.replaceScene(actionEvent,"/ReviewsAndMakeResponsePage2.fxml");
        } catch (SystemException | EmptyInputException e) {
            CreateNotification.createNotification(e);
        }
    }

    @FXML
    public void goToUserPage(ActionEvent actionEvent) {
        try {
            SwitchAndSetPage2 replacer = new SwitchAndSetPage2();
            replacer.switchAndSetSceneUser(actionEvent,"/ViewUserPageFromCO2.fxml",userBean);
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }
}
