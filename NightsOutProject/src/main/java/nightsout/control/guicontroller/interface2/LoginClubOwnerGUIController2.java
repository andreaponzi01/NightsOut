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
import nightsout.utils.scene.ReplaceScene;
import nightsout.utils.scene.ReplaceSceneDynamic2;

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
            ReplaceSceneDynamic2 replacer = new ReplaceSceneDynamic2();
            LoginAppController.loginClubOwner2(credentialsBean);
            replacer.switchAndSetScene(ae, "/ClubOwnerPage2.fxml");
        } catch (SystemException | WrongCredentialsException e) {
            MyNotification.createNotification(e);
        }
    }

    @FXML
    private void goToRegisterPage(ActionEvent actionEvent) {

        try {
            ReplaceSceneDynamic2 replacer = new ReplaceSceneDynamic2();
            replacer.switchAndSetScene(actionEvent, "/RegisterClubOwner2.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    @FXML
    private void backToWelcomePage(ActionEvent actionEvent) { ReplaceScene.replaceScene(actionEvent, "/Welcome2.fxml"); }
}
