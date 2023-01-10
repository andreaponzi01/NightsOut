package nightsout.control.guicontroller.interface2.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.control.appcontroller.EventReviewsClubOwnerAppController;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.LoggedBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage2;

public class ReviewItemGUIController2 {

    private UserBean2 userBean;

    @FXML
    private Label labelComment;
    @FXML
    private Label labelEventName;
    @FXML
    private Label labelUsername;

    public void setAll(ReviewBean reviewBean) throws SystemException {

        this.labelComment.setText(reviewBean.getComment());
        try {
            this.userBean = new UserBean2(EventReviewsClubOwnerAppController.searchUserbyIdUser(reviewBean.getIdUser()));
        } catch (SystemException e) {
            ExceptionHandler.handleException(e);
        }
        EventBean eventBean = EventReviewsClubOwnerAppController.searchEventbyIdEvent(reviewBean.getIdEvent());
        this.labelUsername.setText(userBean.getUsername());
        this.labelEventName.setText(eventBean.getName());
    }


    public void goToUserPage(ActionEvent actionEvent) {

        try {
            String type = LoggedBean.getInstance().checkInstanceType();
            if (type.equalsIgnoreCase("FREE")) {
                SwitchAndSetPage2.switchAndSetSceneUser(actionEvent,"/ViewUserPageFromUser2.fxml",userBean);
            } else {
                SwitchAndSetPage2.switchAndSetSceneUser(actionEvent,"/ViewUserPageFromCO2.fxml",userBean);
            }
        } catch (SystemException e) {
            ExceptionHandler.handleException(e);
        }
    }
}
