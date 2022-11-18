package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nightsout.control.appcontroller.SubscriptionVipAppController;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;

public class SubscriptionVipPageGUIController1 {

    private UserBean userBean;

    @FXML
    private void backToUserPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml", userBean,null);
    }

    @FXML
    private void confirmSubscription(ActionEvent actionEvent) throws IOException, SQLException {
        UserBean userBeanUpdated = SubscriptionVipAppController.subscription(userBean);
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml", userBeanUpdated,null);
    }

    public void setAll(UserBean userBean) { this.userBean = userBean; }

}
