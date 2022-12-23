package nightsout.control.guicontroller.interface2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nightsout.control.appcontroller.RegisterAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.CredentialsBean;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.myexception.*;
import nightsout.utils.scene.switchPage.SwitchPage;

import java.io.File;

public class RegisterUserGUIController2 {

    @FXML
    TextField textFieldName;
    @FXML
    TextField textFieldUsername;
    @FXML
    TextField textFieldSurname;
    @FXML
    TextField textFieldEmail;
    @FXML
    PasswordField passwordField;
    @FXML
    TextField textFieldBirthday;
    @FXML
    TextField textFieldGender;
    @FXML
    ImageView imageViewProfile;
    private File img;

    @FXML
    private void goToWelcomePage(ActionEvent actionEvent) {

        UserBean2 userBean;
        CredentialsBean credentialsBean;

        try {
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
            RegisterAppController.registerUser(userBean, credentialsBean);
            SwitchPage.replaceScene(actionEvent, "/Welcome2.fxml");
        } catch (EmptyInputException | EmailNotValidException | SystemException | UsernameAlreadyTakenException |
                 PasswordNotCompliantException | AdultException | GenderException | WrongInputTypeException e) {
            MyNotification.createNotification(e);
        }
    }

    public void loadImage() {

        Stage stage = (Stage) textFieldUsername.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagine Files", "*.png", "*.jpg", "*.jpeg"));
        img = fileChooser.showOpenDialog(stage).getAbsoluteFile();
        this.imageViewProfile.setImage(new Image(img.toURI().toString()));
    }

    @FXML
    public void backToLogin(ActionEvent actionEvent) {
        SwitchPage.replaceScene(actionEvent, "/LoginUser2.fxml");
    }

}
