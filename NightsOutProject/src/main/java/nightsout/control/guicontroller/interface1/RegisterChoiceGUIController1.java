package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import nightsout.utils.scenes.ReplaceScene;

public class RegisterChoiceGUIController1 {

    @FXML
    Button buttonClubOwner, buttonUser, backToWelcomePane;

    @FXML
    protected void goToClubOwnerRegister(ActionEvent actionEvent) { ReplaceScene.replaceScene(actionEvent, "/RegisterClubOwner1.fxml"); }

    @FXML
    protected void goToUserRegister(ActionEvent actionEvent) { ReplaceScene.replaceScene(actionEvent, "/RegisterUser1.fxml"); }

    @FXML
    protected void backToWelcomePane(ActionEvent actionEvent) { ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml"); }
}
