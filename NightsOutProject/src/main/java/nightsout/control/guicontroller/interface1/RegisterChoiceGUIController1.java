package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import nightsout.utils.scene.switchpage.SwitchPage;

public class RegisterChoiceGUIController1 {

    @FXML
    Button buttonClubOwner;
    @FXML
    Button buttonUser;
    @FXML
    protected void goToClubOwnerRegister(ActionEvent actionEvent) { SwitchPage.replaceScene(actionEvent, "/RegisterClubOwner1.fxml"); }
    @FXML
    protected void goToUserRegister(ActionEvent actionEvent) { SwitchPage.replaceScene(actionEvent, "/RegisterUser1.fxml"); }
    @FXML
    protected void backToWelcomePane(ActionEvent actionEvent) { SwitchPage.replaceScene(actionEvent, "/Welcome1.fxml"); }
}
