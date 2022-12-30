package nightsout.control.guicontroller.interface1.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nightsout.control.appcontroller.SubscriptionVipAppController;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.interface1.LoggedUserBean1;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchPage;

public class SubscriptionVipPageGUIController1 {

    @FXML
    public void backToUserPage(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent,"/UserPage1.fxml");}

    @FXML
    private void confirmSubscription(ActionEvent actionEvent) {

        try {
            LoggedUserBean1.updateInstance(SubscriptionVipAppController.subscription(LoggedUserBean1.getInstance()));
            SwitchPage.replaceScene(actionEvent,"/UserPage1.fxml");
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }
}
