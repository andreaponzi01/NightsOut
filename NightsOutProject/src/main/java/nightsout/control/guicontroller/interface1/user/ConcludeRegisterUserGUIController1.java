package nightsout.control.guicontroller.interface1.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nightsout.control.appcontroller.RegisterAppController;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.CredentialsBean;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.*;
import nightsout.utils.scene.switchpage.SwitchPage;

import java.io.File;

public class ConcludeRegisterUserGUIController1 {

    private UserBean1 userBean1;
    private File img;
    @FXML
    TextField textFieldEmail;
    @FXML
    TextField textFieldUsername;
    @FXML
    PasswordField passwordField;
    @FXML
    ImageView imageViewProfile;
    @FXML
    Button buttonBack;

    public void setAll(UserBean1 userBean1) {
        this.userBean1 = userBean1;
    }
    @FXML
    protected void backToRegister(ActionEvent actionEvent) { SwitchPage.replaceScene(actionEvent, "/RegisterUser1.fxml"); }
    @FXML
    protected void goToWelcomePage(ActionEvent actionEvent) {
        CredentialsBean credentialsBean;
        try {
            credentialsBean = new CredentialsBean();
            userBean1.setUsername(textFieldUsername.getText());
            credentialsBean.setUsername(textFieldUsername.getText());
            credentialsBean.setPassword(passwordField.getText());
            credentialsBean.setType("Free");
            userBean1.setEmail(textFieldEmail.getText());
            userBean1.setImg(img);
            RegisterAppController.registerUser(userBean1, credentialsBean);
            SwitchPage.replaceScene(actionEvent, "/Welcome1.fxml");
        } catch (EmptyInputException | EmailNotValidException | SystemException | UsernameAlreadyTakenException |
                 PasswordNotCompliantException e) {
            CreateNotification.createNotification(e);
        }
    }

    public void loadImage() {
        Stage stage = (Stage) textFieldUsername.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagine Files", "*.png", "*.jpg", "*.jpeg"));
        img = fileChooser.showOpenDialog(stage).getAbsoluteFile();
        this.imageViewProfile.setImage(new Image(img.toURI().toString()));
    }
}
