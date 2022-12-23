package nightsout.control.guicontroller.interface2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import nightsout.control.appcontroller.LoginAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.CredentialsBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.exception.myexception.WrongCredentialsException;
import nightsout.utils.scene.switchPage.SwitchPage;
import nightsout.utils.scene.switchPage.SwitchAndSetPage2;

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
            SwitchAndSetPage2 replacer = new SwitchAndSetPage2();
            LoginAppController.loginClubOwner2(credentialsBean);
            replacer.switchAndSetScene(ae, "/ClubOwnerPage2.fxml");
        } catch (SystemException | WrongCredentialsException e) {
            MyNotification.createNotification(e);
        }
    }

    @FXML
    protected void backToWelcomePage(ActionEvent actionEvent) { SwitchPage.replaceScene(actionEvent, "/Welcome2.fxml"); }

    @FXML
    private void goToRegisterPage(ActionEvent actionEvent) {

        try {
            SwitchAndSetPage2 replacer = new SwitchAndSetPage2();
            replacer.switchAndSetScene(actionEvent, "/RegisterClubOwner2.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }
}
