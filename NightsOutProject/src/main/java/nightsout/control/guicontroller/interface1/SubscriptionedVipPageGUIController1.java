package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.LoggedUserBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.time.format.DateTimeFormatter;

public class SubscriptionedVipPageGUIController1 {

    @FXML
    protected Label labelDate;
    @FXML
    private MenuUserGUIController1 menuController;

    public void setLabelDate(String date) { this.labelDate.setText(date); }

    public void setAll() {

        this.menuController.setAll();
        setLabelDate(LoggedUserBean.getInstance().getCreationDateVIP().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
    }

    public void backToUserPage(ActionEvent actionEvent) {
        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    public void goToUserPage(ActionEvent actionEvent) {

        try {
              ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
              replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml");
          } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }
}
