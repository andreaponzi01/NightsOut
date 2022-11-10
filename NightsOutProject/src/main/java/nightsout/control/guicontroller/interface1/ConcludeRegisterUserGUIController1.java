package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import nightsout.control.appcontroller.RegisterAppController;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceScene;

import java.time.LocalDate;

public class ConcludeRegisterUserGUIController1 {

    private UserBean userBean;
    @FXML
    TextField textFieldEmail;
    @FXML
    TextField textFieldUsername;
    @FXML
    TextField textFieldPassword;
    @FXML
    Button buttonBack;
    @FXML
    Button buttonSubmit;

    @FXML
    protected void backToRegister(ActionEvent actionEvent) {ReplaceScene.replaceScene(actionEvent, "/RegisterUser1.fxml");}
    @FXML
    protected void goToWelcomePage(ActionEvent actionEvent) {

        userBean.setUsername(textFieldUsername.getText());
        userBean.setPassword(textFieldPassword.getText());
        userBean.setEmail(textFieldEmail.getText());
        RegisterAppController.registerUser(userBean);
        ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml"); }

    public void setAll(String[] personalInfo) {

        userBean = new UserBean();
        userBean.setName(personalInfo[0]);
        userBean.setSurname(personalInfo[1]);
        userBean.setGender(personalInfo[2]);
        userBean.setBirthday(LocalDate.parse(personalInfo[3]));
    }
}
