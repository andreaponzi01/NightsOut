package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nightsout.control.appcontroller.SubscriptionVipAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.LoggedUserBean1;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

public class SubscriptionVipPageGUIController1 {


    public void backToUserPage(ActionEvent actionEvent) {
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
            SubscriptionVipAppController.subscription(LoggedUserBean1.getInstance());
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

}
