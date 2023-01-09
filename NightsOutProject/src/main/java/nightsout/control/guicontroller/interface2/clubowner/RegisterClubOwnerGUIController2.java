package nightsout.control.guicontroller.interface2.clubowner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nightsout.control.appcontroller.RegisterAppController;
import nightsout.utils.bean.CredentialsBean;
import nightsout.utils.bean.interface2.ClubOwnerBean2;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.*;
import nightsout.utils.scene.switchpage.SwitchPage;

import java.io.File;


public class RegisterClubOwnerGUIController2 {

    @FXML
    TextField textFieldUsername;
    @FXML
    TextField textFieldName;
    @FXML
    TextField textFieldEmail;
    @FXML
    TextField textFieldAddress;
    @FXML
    TextField textFieldCity;
    @FXML
    Slider sliderVIPDiscount;
    @FXML
    TextField textFieldCivicNumber;
    @FXML
    PasswordField passwordField;
    @FXML
    ImageView imageViewProfile;

    private File img;

    @FXML
    protected void goToWelcomePage(ActionEvent actionEvent) {

        ClubOwnerBean2 clubOwnerBean;
        CredentialsBean credentialsBean;
        try {
            clubOwnerBean = new ClubOwnerBean2();
            credentialsBean = new CredentialsBean();
            clubOwnerBean.setName(textFieldName.getText());
            clubOwnerBean.setAddress(textFieldAddress.getText(), textFieldCivicNumber.getText());
            clubOwnerBean.setCity(textFieldCity.getText());
            clubOwnerBean.setDiscountVIP((int) sliderVIPDiscount.getValue());
            clubOwnerBean.setUsername(textFieldUsername.getText());
            credentialsBean.setUsername(textFieldUsername.getText());
            credentialsBean.setPassword(passwordField.getText());
            credentialsBean.setType("ClubOwner");
            clubOwnerBean.setEmail(textFieldEmail.getText());
            clubOwnerBean.setImg(img);
            RegisterAppController.registerClubOwner(clubOwnerBean, credentialsBean);
            SwitchPage.replaceScene(actionEvent, "/Welcome2.fxml");
        } catch (EmptyInputException | EmailNotValidException | SystemException | UsernameAlreadyTakenException |
                 PasswordNotCompliantException | WrongInputTypeException e) {
            ExceptionHandler.handleException(e);
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
    public void backToLogin(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent, "/LoginClubOwner2.fxml");}
}
