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

    public ReviewItemToResponseGUIController2() {
        //ignore
    }

    @FXML
    private Label labelComment;
    @FXML
    private Label labelEventName;

    public void setAll(ReviewBean reviewBean) throws SystemException {

        UserBean2 userBean = null;

        this.labelComment.setText(reviewBean.getComment());
        try {
            userBean = new UserBean2(EventReviewsClubOwnerAppController.searchUserbyIdUser(reviewBean.getIdUser()));
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
            userBean = new UserBean2();
        }
        EventBean eventBean = EventReviewsClubOwnerAppController.searchEventbyIdEvent(reviewBean.getIdEvent());
        this.buttonUsername.setText(userBean.getUsername());
        this.labelEventName.setText(eventBean.getName());
    }

    public void goToResponsePage(ActionEvent actionEvent) {
        // da implementare?
    }

    public void goToUserPage(ActionEvent actionEvent) {
        // da implementare?
    }


}
