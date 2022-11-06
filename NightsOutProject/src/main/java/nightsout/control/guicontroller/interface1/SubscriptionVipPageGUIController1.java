package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nightsout.control.appcontroller.SubscriptionVipAppController;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scenes.ReplaceSceneDynamic1;

import java.io.IOException;

public class SubscriptionVipPageGUIController1 {

    private UserBean userBean;

    @FXML
    private void backToUserPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml", userBean,null);
    }

    @FXML
    private void confirmSubscription(ActionEvent actionEvent) throws IOException {
        //effettiva subscription
        SubscriptionVipAppController.subscription(userBean.getUsername());

        //vai alla pagina
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml", userBean,null);
    }

    public void setAll(UserBean userBean) {this.userBean = userBean;}

}
