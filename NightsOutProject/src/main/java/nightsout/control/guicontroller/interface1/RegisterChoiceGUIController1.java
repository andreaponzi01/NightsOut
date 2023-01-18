package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import nightsout.utils.scene.switchpage.SwitchPage;

public class RegisterChoiceGUIController1 {

    @FXML
    private Button buttonClubOwner;
    @FXML
    private Button buttonUser;
    private SwitchPage switchPage = new SwitchPage();
    @FXML
    protected void goToClubOwnerRegister(ActionEvent actionEvent) { switchPage.replaceScene(actionEvent, "/RegisterClubOwner1.fxml"); }
    @FXML
    protected void goToUserRegister(ActionEvent actionEvent) { switchPage.replaceScene(actionEvent, "/RegisterUser1.fxml"); }
    @FXML
    protected void backToWelcomePane(ActionEvent actionEvent) { switchPage.replaceScene(actionEvent, "/Welcome1.fxml"); }
}
