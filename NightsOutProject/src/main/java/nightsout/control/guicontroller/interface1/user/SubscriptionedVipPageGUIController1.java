package nightsout.control.guicontroller.interface1.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import nightsout.utils.Session;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchPage;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class SubscriptionedVipPageGUIController1 implements Initializable {

    @FXML
    private Label labelDate;
    private SwitchPage switchPage = new SwitchPage();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {this.labelDate.setText(Session.getInstance().getUser().getCreationDateVIP().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));}

    @FXML
    private void backToUserPage(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/UserPage1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
