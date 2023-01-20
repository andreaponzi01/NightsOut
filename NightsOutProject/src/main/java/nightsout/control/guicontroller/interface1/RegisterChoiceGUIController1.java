package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nightsout.utils.scene.SwitchPage;

public class RegisterChoiceGUIController1 {

    private SwitchPage switchPage = new SwitchPage();
    @FXML
    protected void goToClubOwnerRegister(ActionEvent actionEvent) { switchPage.replaceScene(actionEvent, "/RegisterClubOwner1.fxml"); }
    @FXML
    protected void goToUserRegister(ActionEvent actionEvent) { switchPage.replaceScene(actionEvent, "/RegisterUser1.fxml"); }
    @FXML
    protected void backToWelcomePane(ActionEvent actionEvent) { switchPage.replaceScene(actionEvent, "/Welcome1.fxml"); }
}
