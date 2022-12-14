package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import nightsout.utils.scene.switchpage.SwitchPage;

public class WelcomeGUIController1 {

    @FXML
    private Button buttonExit;
    @FXML
    private void onSignInClick(ActionEvent actionEvent) {
        SwitchPage.replaceScene(actionEvent, "/Login1.fxml");
    }
    @FXML
    private void onSignOnClick(ActionEvent actionEvent) { SwitchPage.replaceScene(actionEvent, "/RegisterChoice1.fxml"); }
    @FXML
    private void switchInterface(ActionEvent actionEvent) { SwitchPage.replaceScene(actionEvent, "/Welcome2.fxml");}
    @FXML
    private void exit() {
        Stage stage = (Stage) buttonExit.getScene().getWindow();
        stage.close();
    }
}
