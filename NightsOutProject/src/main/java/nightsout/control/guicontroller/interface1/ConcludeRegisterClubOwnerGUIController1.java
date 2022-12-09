package nightsout.control.guicontroller.interface1;

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
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.CredentialsBean;
import nightsout.utils.exception.myexception.*;
import nightsout.utils.scene.ReplaceScene;

import java.io.File;

public class ConcludeRegisterClubOwnerGUIController1 {

    private ClubOwnerBean clubOwnerBean;

    @FXML
    TextField textFieldUsername;
    @FXML
    PasswordField passwordField;
    @FXML
    ImageView imageViewProfile;
    @FXML
    TextField textFieldEmail;
    private File img;
    @FXML
    protected void backToRegister(ActionEvent actionEvent) { ReplaceScene.replaceScene(actionEvent, "/RegisterClubOwner1.fxml"); }

    @FXML
    protected void goToWelcomePage(ActionEvent actionEvent) {
        CredentialsBean credentialsBean;
        try {
            credentialsBean = new CredentialsBean();
            clubOwnerBean.setUsername(textFieldUsername.getText());
            credentialsBean.setUsername(textFieldUsername.getText());
            credentialsBean.setPassword(passwordField.getText());
            credentialsBean.setType("ClubOwner");
            clubOwnerBean.setEmail(textFieldEmail.getText());
            clubOwnerBean.setImg(img);
            RegisterAppController.registerClubOwner(clubOwnerBean, credentialsBean);
            ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml");
        } catch (EmptyInputException | EmailNotValidException | SystemException | UsernameAlreadyTakenException |
                 PasswordNotCompliantException e) {
            MyNotification.createNotification(e);
        }


    }

    public void setAll(ClubOwnerBean clubOwnerBean) {
        this.clubOwnerBean = clubOwnerBean;
    }

    public void loadImage() {
        Stage stage = (Stage) textFieldUsername.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagine Files", "*.png", "*.jpg", "*.jpeg"));
        img = fileChooser.showOpenDialog(stage).getAbsoluteFile();
        this.imageViewProfile.setImage(new Image(img.toURI().toString()));
    }
}