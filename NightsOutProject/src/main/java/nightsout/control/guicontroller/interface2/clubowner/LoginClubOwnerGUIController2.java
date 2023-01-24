package nightsout.control.guicontroller.interface2.clubowner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import nightsout.control.appcontroller.LoginAppController;
import nightsout.utils.bean.CredentialsBean;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.exception.myexception.WrongCredentialsException;
import nightsout.utils.switchpage.SwitchPage;

public class LoginClubOwnerGUIController2 {

    @FXML
    private TextField textFieldUsername;
    @FXML
    private PasswordField passwordField;
    private SwitchPage switchPage = new SwitchPage();

    @FXML
    private void loginAction(ActionEvent ae) {

        String type = "ClubOwner";
        LoginAppController controller= new LoginAppController();

        try {
            CredentialsBean credentialsBean = new CredentialsBean(textFieldUsername.getText(), passwordField.getText(), type);
            controller.login(credentialsBean);
            switchPage.replaceScene(ae,"/ClubOwnerPage2.fxml");
        } catch (SystemException | WrongCredentialsException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }


    @FXML
    protected void backToWelcomePage(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/Welcome2.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void goToRegisterPage(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/RegisterClubOwner2.fxml");
        } catch (SystemException e){
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
