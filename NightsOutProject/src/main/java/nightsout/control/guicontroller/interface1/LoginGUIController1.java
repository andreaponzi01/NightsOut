package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import nightsout.control.appcontroller.LoginAppController;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.CredentialsBean;
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

            if (Objects.equals(type, "ClubOwner")) {
                LoginAppController.loginClubOwner1(credentialsBean);
                SwitchPage.replaceScene(ae,"/ClubOwnerPage1.fxml");
            } else {
                LoginAppController.loginUser1(credentialsBean);
                SwitchPage.replaceScene(ae,"/UserPage1.fxml");
            }
        } catch (SystemException | WrongCredentialsException e) {
            CreateNotification.createNotification(e);
        }
    }

    @FXML
    protected void backToWelcomePage(ActionEvent actionEvent) { SwitchPage.replaceScene(actionEvent, "/Welcome1.fxml"); }
}
