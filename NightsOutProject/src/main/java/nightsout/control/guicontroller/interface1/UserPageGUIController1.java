package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scenes.ReplaceSceneDynamic1;

import java.io.IOException;

public class UserPageGUIController1 {

    @FXML
    protected Label usernameLabel;
    protected UserBean userBean;

    public void setLabelUserName(String username) { this.usernameLabel.setText(username); }

    public void setAll(UserBean userBean) {
        this.userBean = userBean;
        setLabelUserName(userBean.getUsername());
    }

    @FXML
    private void goToSubscriptionPage(ActionEvent actionEvent) throws IOException {
        if (userBean.getVip()) {
            System.out.println("Already subscriptioned");
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneSubscription(actionEvent, "/SubscriptionedVipPage1.fxml", userBean);
        }
        else
        {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneSubscription(actionEvent, "/SubscriptionVipPage1.fxml", userBean);

            //é giusto settarli qui i BEAN?
            //devo settare anche il model? se si dove lo setto il MODEL?


            //  userBean.setVip(TRUE);
            //  userBean.setCreationDateVIP(LocalDate.now());
        }
    }

}
