package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import nightsout.control.appcontroller.LoginAppController;
import nightsout.utils.bean.CredentialsBean;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.exception.myexception.WrongCredentialsException;
import nightsout.utils.scene.SwitchPage;

import java.util.Objects;

public class LoginGUIController1 {

    @FXML
    private TextField textFieldUsername;
    @FXML
    private PasswordField passwordField;
    @FXML
    private CheckBox checkBoxClubOwner;

    private SwitchPage switchPage = new SwitchPage();

    @FXML
    void loginAction(ActionEvent ae) {

        String type = "Free";
        LoginAppController controller;

        if(checkBoxClubOwner.isSelected()) {type = "ClubOwner";}
        try {
            controller = new LoginAppController();

            CredentialsBean credentialsBean = new CredentialsBean(textFieldUsername.getText(), passwordField.getText(), type);
            controller.login(credentialsBean);
            if (Objects.equals(type, "ClubOwner")) {
                switchPage.replaceScene(ae,"/ClubOwnerPage1.fxml");
            } else {
                switchPage.replaceScene(ae,"/UserPage1.fxml");
            }
        } catch (SystemException | WrongCredentialsException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    protected void backToWelcomePage(ActionEvent actionEvent) { switchPage.replaceScene(actionEvent, "/Welcome1.fxml"); }
}
