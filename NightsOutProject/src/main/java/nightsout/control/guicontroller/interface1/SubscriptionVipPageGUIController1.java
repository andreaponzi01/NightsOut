package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nightsout.control.appcontroller.SubscriptionVipAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.LoggedUserBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;

public class SubscriptionVipPageGUIController1 {

    private UserBean userBean;
    @FXML
    private MenuUserGUIController1 menuController;

    public void backToUserPage(ActionEvent actionEvent) throws IOException {
        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    @FXML
    private void confirmSubscription(ActionEvent actionEvent) {
        try {
            //UserBean userBeanUpdated = SubscriptionVipAppController.subscription(userBean);
            UserBean userBean = LoggedUserBean.getInstance();
            SubscriptionVipAppController.subscription(userBean);
            //cambiare il bean perche cosi ho cambiato solo il db
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    public void setAll() throws SQLException {
        this.userBean = LoggedUserBean.getInstance();
        this.menuController.setAll();
    }

}
