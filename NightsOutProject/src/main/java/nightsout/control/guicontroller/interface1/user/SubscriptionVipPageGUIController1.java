package nightsout.control.guicontroller.interface1.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nightsout.control.appcontroller.SubscriptionVipAppController;
import nightsout.utils.Session;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.SwitchPage;

public class SubscriptionVipPageGUIController1 {

    private SwitchPage switchPage = new SwitchPage();

    @FXML
    public void backToUserPage(ActionEvent actionEvent) {switchPage.replaceScene(actionEvent,"/UserPage1.fxml");}

    @FXML
    private void confirmSubscription(ActionEvent actionEvent) {

        SubscriptionVipAppController controller = new SubscriptionVipAppController();
        try {
            Session.getInstance().setUser(controller.subscription(Session.getInstance().getUser()));
            switchPage.replaceScene(actionEvent,"/UserPage1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
