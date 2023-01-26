package nightsout.control.guicontroller.interface1.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nightsout.control.appcontroller.SubscriptionVipAppController;
import nightsout.utils.Session;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchPage;

public class SubscriptionVipPageGUIController1 {

    private SwitchPage switchPage = new SwitchPage();

    @FXML
    private void backToUserPage(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent,"/UserPage1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void confirmSubscription(ActionEvent actionEvent) {

        SubscriptionVipAppController controller = new SubscriptionVipAppController();
        try {
           controller.subscription(Session.getInstance().getUser());
           Session.getInstance().updateVIP();
           switchPage.replaceScene(actionEvent,"/UserPage1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
