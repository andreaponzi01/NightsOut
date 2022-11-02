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
        //welcomeText.setText("This is NightsOut!");
        ReplaceScene.replaceScene(actionEvent, "/Login1.fxml");
    }
}
