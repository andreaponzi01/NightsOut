package nightsout.control.guicontroller.interface2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import nightsout.utils.scene.ReplaceScene;

public class WelcomeGUIController2 {

    @FXML
    private Button buttonExit;

    @FXML
    private void goToClubOwnerLogin(ActionEvent actionEvent) { ReplaceScene.replaceScene(actionEvent, "/LoginClubOwner2.fxml");}
    @FXML
    private void goToUserLogin(ActionEvent actionEvent) { ReplaceScene.replaceScene(actionEvent, "/LoginUser2.fxml"); }
    @FXML
    private void switchInterface(ActionEvent actionEvent) { ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml"); }

    @FXML
    private void exit() {
        Stage stage = (Stage) buttonExit.getScene().getWindow();
        stage.close();
    }
}
