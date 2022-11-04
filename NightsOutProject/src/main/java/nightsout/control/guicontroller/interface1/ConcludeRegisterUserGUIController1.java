package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import nightsout.utils.scenes.ReplaceScene;

public class ConcludeRegisterUserGUIController1 {

    @FXML
    TextField textFieldEmail, textFieldUsername, textFieldPassword;

    @FXML
    Button buttonBack, buttonSubmit;

    @FXML
    protected void backToRegister(ActionEvent actionEvent) { ReplaceScene.replaceScene(actionEvent, "/RegisterUser1.fxml"); }

    @FXML
    protected void goToWelcomePage(ActionEvent actionEvent) { ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml"); }

}
