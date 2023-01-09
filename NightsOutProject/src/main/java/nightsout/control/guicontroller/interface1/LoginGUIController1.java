package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import nightsout.control.appcontroller.LoginAppController;
import nightsout.utils.bean.CredentialsBean;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.exception.myexception.WrongCredentialsException;
import nightsout.utils.scene.switchpage.SwitchPage;

import java.util.Objects;

public class LoginGUIController1 {

    @FXML
    TextField textFieldUsername;
    @FXML
    PasswordField passwordField;
    @FXML
    Button buttonLogin;
    @FXML
    Button buttonBack;
    @FXML
    CheckBox checkBoxClubOwner;

    @FXML
    void loginAction(ActionEvent ae) {

        String type = "Free";
        if(checkBoxClubOwner.isSelected()) {type = "ClubOwner";}
        try {
            CredentialsBean credentialsBean = new CredentialsBean(textFieldUsername.getText(), passwordField.getText(), type);
            LoginAppController.login(credentialsBean);
            if (Objects.equals(type, "ClubOwner")) {
                SwitchPage.replaceScene(ae,"/ClubOwnerPage1.fxml");
            } else {
                SwitchPage.replaceScene(ae,"/UserPage1.fxml");
            }
        } catch (SystemException | WrongCredentialsException e) {
            ExceptionHandler.handleException(e);
        }
    }

    @FXML
    protected void backToWelcomePage(ActionEvent actionEvent) { SwitchPage.replaceScene(actionEvent, "/Welcome1.fxml"); }
}
