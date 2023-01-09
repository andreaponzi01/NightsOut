package nightsout.control.guicontroller.interface1.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import nightsout.utils.bean.LoggedBean;
import nightsout.utils.scene.switchpage.SwitchPage;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class SubscriptionedVipPageGUIController1 implements Initializable {

    @FXML
    protected Label labelDate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {this.labelDate.setText(LoggedBean.getInstance().getUser().getCreationDateVIP().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));}
    @FXML
    public void backToUserPage(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent,"/UserPage1.fxml");}
}
