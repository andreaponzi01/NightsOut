package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchPage;

public class WelcomeGUIController1 {

    @FXML
    private Button buttonExit;
    private SwitchPage switchPage = new SwitchPage();

    @FXML
    private void onSignInClick(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/Login1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void onSignOnClick(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/RegisterChoice1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
    @FXML
    private void exit() {
        Stage stage = (Stage) buttonExit.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void switchInterface(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/Welcome2.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
