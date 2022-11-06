package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nightsout.utils.bean.UserBean;

public class SubscriptionPageGUIController1 {

    private UserBean userBean;

    @FXML
    private void backToUserPage(ActionEvent actionEvent) {

    }

    @FXML
    private void confirmSubscription(ActionEvent actionEvent) {

    }

    public void setAll(UserBean userBean) {
        this.userBean = userBean;
    }

}
