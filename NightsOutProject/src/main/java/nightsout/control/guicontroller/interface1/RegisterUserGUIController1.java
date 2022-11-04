package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import nightsout.utils.scenes.ReplaceScene;

public class RegisterUserGUIController1 {

    @FXML
    Button buttonNextStep, buttonBack;

    @FXML
    Label labelName;

    @FXML
    protected void backToChoice(ActionEvent actionEvent) { ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml"); }

}
