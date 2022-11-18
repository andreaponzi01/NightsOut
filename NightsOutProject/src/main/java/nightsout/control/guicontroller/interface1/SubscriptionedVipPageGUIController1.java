package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;

public class SubscriptionedVipPageGUIController1 {

    @FXML
    protected Label labelDate;

    protected UserBean userBean;

    public void setLabelDate(String date) { this.labelDate.setText(date); }


    public void setAll(UserBean userBean) {
        this.userBean = userBean;
        setLabelDate(userBean.getCreationDateVIP().toString());
    }

    public void goToUserPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml", userBean,null);
    }
}
