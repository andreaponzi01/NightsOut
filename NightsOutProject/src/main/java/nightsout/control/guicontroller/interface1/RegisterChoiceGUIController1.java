package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchPage;

public class RegisterChoiceGUIController1 {

    private SwitchPage switchPage = new SwitchPage();
    @FXML
    private void goToClubOwnerRegister(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/RegisterClubOwner1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
    @FXML
    private void goToUserRegister(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/RegisterUser1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
    @FXML
    private void backToWelcomePane(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/Welcome1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
