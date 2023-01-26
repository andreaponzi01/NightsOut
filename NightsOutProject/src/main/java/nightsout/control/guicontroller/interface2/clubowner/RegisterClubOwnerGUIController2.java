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
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.*;
import nightsout.utils.switchpage.SwitchPage;

import java.io.File;


public class RegisterClubOwnerGUIController2 {

    @FXML
    private TextField textFieldUsername;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldAddress;
    @FXML
    private TextField textFieldCity;
    @FXML
    private Slider sliderVIPDiscount;
    @FXML
    private TextField textFieldCivicNumber;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ImageView imageViewProfile;
    private SwitchPage switchPage = new SwitchPage();
    private File img;

    @FXML
    private void loadImage() {
        Stage stage = (Stage) textFieldUsername.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagine Files", "*.png", "*.jpg", "*.jpeg"));
        img = fileChooser.showOpenDialog(stage).getAbsoluteFile();
        imageViewProfile.setImage(new Image(img.toURI().toString()));
    }

    @FXML
    private void goToWelcomePage(ActionEvent actionEvent) {

        ClubOwnerBean2 clubOwnerBean;
        CredentialsBean credentialsBean;
        RegisterAppController controller;
        try {
            controller = new RegisterAppController();
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
            controller.registerClubOwner(clubOwnerBean, credentialsBean);
            switchPage.replaceScene(actionEvent, "/Welcome2.fxml");
        } catch (EmptyInputException | EmailNotValidException | SystemException | UsernameAlreadyTakenException |
                 PasswordNotCompliantException | WrongInputTypeException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void backToLogin(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/LoginClubOwner2.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
