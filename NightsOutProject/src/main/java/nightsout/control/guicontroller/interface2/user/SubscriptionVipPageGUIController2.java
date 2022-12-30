package nightsout.control.guicontroller.interface2.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nightsout.control.appcontroller.SubscriptionVipAppController;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.interface2.LoggedUserBean2;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchPage;

public class SubscriptionVipPageGUIController2 {

    public void backToUserPage(ActionEvent actionEvent) {
        SwitchPage.replaceScene(actionEvent,"/UserPage2.fxml");
    }

    @FXML
    private void confirmSubscription(ActionEvent actionEvent) {

        try {
            SubscriptionVipAppController.subscription(LoggedUserBean2.getInstance());
            SwitchPage.replaceScene(actionEvent,"/UserPage2.fxml");
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }


}
