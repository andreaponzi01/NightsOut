package nightsout.control.guicontroller.interface2.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nightsout.control.appcontroller.RegisterAppController;
import nightsout.utils.bean.CredentialsBean;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.*;
import nightsout.utils.switchpage.SwitchPage;

import java.io.File;

public class RegisterUserGUIController2 {

    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldUsername;
    @FXML
    private TextField textFieldSurname;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField textFieldBirthday;
    @FXML
    private TextField textFieldGender;
    @FXML
    private ImageView imageViewProfile;
    private File img;
    private SwitchPage switchPage = new SwitchPage();

    @FXML
    private void goToWelcomePage(ActionEvent actionEvent) {

        UserBean2 userBean;
        CredentialsBean credentialsBean;
        RegisterAppController controller;

        try {
            controller = new RegisterAppController();
            userBean = new UserBean2();
            userBean.setName(textFieldName.getText());
            userBean.setSurname(textFieldSurname.getText());
            userBean.setGender(textFieldGender.getText());
            userBean.setBirthday(textFieldBirthday.getText());
            credentialsBean = new CredentialsBean();
            userBean.setUsername(textFieldUsername.getText());
            credentialsBean.setUsername(textFieldUsername.getText());
            credentialsBean.setPassword(passwordField.getText());
            credentialsBean.setType("Free");
            userBean.setEmail(textFieldEmail.getText());
            userBean.setImg(img);
            controller.registerUser(userBean, credentialsBean);
            switchPage.replaceScene(actionEvent, "/Welcome2.fxml");
        } catch (EmptyInputException | EmailNotValidException | SystemException | UsernameAlreadyTakenException |
                 PasswordNotCompliantException | AdultException | GenderException | WrongInputTypeException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    public void loadImage() {

        Stage stage = (Stage) textFieldUsername.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagine Files", "*.png", "*.jpg", "*.jpeg"));
        img = fileChooser.showOpenDialog(stage).getAbsoluteFile();
        imageViewProfile.setImage(new Image(img.toURI().toString()));
    }

    @FXML
    public void backToLogin(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/LoginUser2.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

}
