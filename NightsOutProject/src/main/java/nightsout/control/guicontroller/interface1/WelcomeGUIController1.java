package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.scenes.ReplaceScene;

public class WelcomeGUIController1 {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onSignInClick(ActionEvent actionEvent) {
        ReplaceScene.replaceScene(actionEvent, "/Login1.fxml");
    }

    @FXML
    protected void onSignOnClick(ActionEvent actionEvent) { ReplaceScene.replaceScene(actionEvent, "/RegisterChoice1.fxml"); }
}
