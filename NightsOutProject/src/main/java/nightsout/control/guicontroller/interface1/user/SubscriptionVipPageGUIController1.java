package nightsout.control.guicontroller.interface1.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nightsout.control.appcontroller.SubscriptionVipAppController;
import nightsout.utils.bean.LoggedBean;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchPage;

public class SubscriptionVipPageGUIController1 {

    @FXML
    public void backToUserPage(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent,"/UserPage1.fxml");}

    @FXML
    private void confirmSubscription(ActionEvent actionEvent) {

        try {
            LoggedBean.getInstance().setUser(SubscriptionVipAppController.subscription(LoggedBean.getInstance().getUser()));
            SwitchPage.replaceScene(actionEvent,"/UserPage1.fxml");
        } catch (SystemException e) {
            ExceptionHandler.handleException(e);
        }
    }
}
