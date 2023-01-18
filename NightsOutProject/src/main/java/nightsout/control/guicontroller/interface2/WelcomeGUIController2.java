package nightsout.control.guicontroller.interface2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import nightsout.utils.scene.switchpage.SwitchPage;

public class WelcomeGUIController2 {

    @FXML
    private Button buttonExit;
    private SwitchPage switchPage = new SwitchPage();
    @FXML
    private void goToClubOwnerLogin(ActionEvent actionEvent) { switchPage.replaceScene(actionEvent, "/LoginClubOwner2.fxml");}
    @FXML
    private void goToUserLogin(ActionEvent actionEvent) { switchPage.replaceScene(actionEvent, "/LoginUser2.fxml"); }
    @FXML
    private void switchInterface(ActionEvent actionEvent) { switchPage.replaceScene(actionEvent, "/Welcome1.fxml"); }
    @FXML
    private void exit() {
        Stage stage = (Stage) buttonExit.getScene().getWindow();
        stage.close();
    }
}
