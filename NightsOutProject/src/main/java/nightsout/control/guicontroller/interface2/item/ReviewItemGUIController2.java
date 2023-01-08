package nightsout.control.guicontroller.interface2.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nightsout.control.appcontroller.EventReviewsClubOwnerAppController;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage2;

public class ReviewItemGUIController2 {

    @FXML
    public Button buttonUsername;
    private UserBean2 userBean;

    @FXML
    private Label labelComment;
    @FXML
    private Label labelEventName;
    @FXML
    TextField textFieldResponse;

    public void setAll(ReviewBean reviewBean) throws SystemException {

        this.labelComment.setText(reviewBean.getComment());
        try {
            this.userBean = new UserBean2(EventReviewsClubOwnerAppController.searchUserbyIdUser(reviewBean.getIdUser()));
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
            e.getCause().printStackTrace();
        }
        EventBean eventBean = EventReviewsClubOwnerAppController.searchEventbyIdEvent(reviewBean.getIdEvent());
        this.buttonUsername.setText(userBean.getUsername());
        this.labelEventName.setText(eventBean.getName());
    }


    public void goToUserPage(ActionEvent actionEvent) {

        try {
            SwitchAndSetPage2 replacer = new SwitchAndSetPage2();
            replacer.switchAndSetSceneUser(actionEvent,"/ViewUserPageFromCO2.fxml", userBean);
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }
}
