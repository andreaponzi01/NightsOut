package nightsout.control.guicontroller.interface1.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.control.appcontroller.EventReviewsClubOwnerAppController;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.LoggedBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage1;
import nightsout.utils.scene.switchpage.SwitchPage;

public class ReviewItemGUIController1 {


    private UserBean1 userBean1;
    private ReviewBean reviewBean;
    @FXML
    private Label labelComment;
    @FXML
    private Label labelEventName;
    @FXML
    public Label labelUsername;

    public void setAll(ReviewBean reviewBean) throws SystemException {
        this.reviewBean = reviewBean;
        this.labelComment.setText(reviewBean.getComment());
        this.userBean1 = new UserBean1(EventReviewsClubOwnerAppController.searchUserbyIdUser(reviewBean.getIdUser()));
        EventBean eventBean = EventReviewsClubOwnerAppController.searchEventbyIdEvent(reviewBean.getIdEvent());
        this.labelUsername.setText(userBean1.getUsername());
        this.labelEventName.setText(eventBean.getName());
    }
    @FXML
    public void goToResponsePage(ActionEvent actionEvent) {

        try {
            SwitchAndSetPage1.switchAndSetSceneMakeResponse(actionEvent, "/MakeResponsePage1.fxml", userBean1, reviewBean);
        } catch (SystemException e) {
            ExceptionHandler.handleException(e);
        }
    }
    @FXML
    public void goToUserPage(ActionEvent actionEvent) {

        try {
            String type = LoggedBean.getInstance().checkInstanceType();
            if (type.equalsIgnoreCase("FREE")) {
                if(userBean1.getId()== LoggedBean.getInstance().getUser().getId())
                    SwitchPage.replaceScene(actionEvent,"/UserPage1.fxml");
                else
                    SwitchAndSetPage1.switchAndSetSceneUser(actionEvent,"/ViewUserPageFromUser1.fxml",userBean1);
            } else {
                SwitchAndSetPage1.switchAndSetSceneUser(actionEvent,"/ViewUserPageFromCO1.fxml",userBean1);
            }
        } catch (SystemException e) {
            ExceptionHandler.handleException(e);
        }
    }
}
