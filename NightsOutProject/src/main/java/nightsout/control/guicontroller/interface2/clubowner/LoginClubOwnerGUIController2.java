package nightsout.control.guicontroller.interface2.clubowner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import nightsout.control.appcontroller.LoginAppController;
import nightsout.utils.bean.CredentialsBean;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.exception.myexception.WrongCredentialsException;
import nightsout.utils.scene.switchpage.SwitchPage;

public class LoginClubOwnerGUIController2 {

    @FXML
    TextField textFieldUsername;
    @FXML
    PasswordField passwordField;
    @FXML
    Button buttonLogin;
    @FXML
    Button buttonBack;

    @FXML
    private void loginAction(ActionEvent ae) {

        String type = "ClubOwner";
        try {
            CredentialsBean credentialsBean = new CredentialsBean(textFieldUsername.getText(), passwordField.getText(), type);
            LoginAppController.login(credentialsBean);
            SwitchPage.replaceScene(ae,"/ClubOwnerPage2.fxml");
        } catch (SystemException | WrongCredentialsException e) {
            ExceptionHandler.handleException(e);
        }
    }

    @FXML
    protected void backToWelcomePage(ActionEvent actionEvent) { SwitchPage.replaceScene(actionEvent, "/Welcome2.fxml"); }

    @FXML
    private void goToRegisterPage(ActionEvent actionEvent) {
        SwitchPage.replaceScene(actionEvent,"/RegisterClubOwner2.fxml");
    }
}
