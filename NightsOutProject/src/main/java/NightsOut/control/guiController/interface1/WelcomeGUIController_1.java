package NightsOut.control.guiController.interface1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WelcomeGUIController_1 {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
