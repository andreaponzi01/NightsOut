package nightsout.control.guicontroller.interface2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchPage;

public class WelcomeGUIController2 {

    @FXML
    private Button buttonExit;
    private SwitchPage switchPage = new SwitchPage();
    @FXML
    private void goToClubOwnerLogin(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/LoginClubOwner2.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void goToUserLogin(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/LoginUser2.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void switchInterface(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/Welcome1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void exit() {
        Stage stage = (Stage) buttonExit.getScene().getWindow();
        stage.close();
    }
}
