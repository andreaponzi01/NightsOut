package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import nightsout.control.appcontroller.RegisterAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.exception.myexception.EmailNotValidException;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.exception.myexception.WrongInputTypeException;
import nightsout.utils.scene.ReplaceScene;

public class ConcludeRegisterClubOwnerGUIController1 {

    private ClubOwnerBean clubOwnerBean;
    @FXML
    Button buttonBack;
    Button buttonSubmit;
    @FXML
    TextField textFieldUsername;
    @FXML
    TextField textFieldPassword;
    @FXML
    TextField textFieldEmail;
    @FXML
    protected void backToRegister(ActionEvent actionEvent) { ReplaceScene.replaceScene(actionEvent, "/RegisterClubOwner1.fxml"); }

    @FXML
    protected void goToWelcomePage(ActionEvent actionEvent) throws EmptyInputException {
        clubOwnerBean.setUsername(textFieldUsername.getText());
        clubOwnerBean.setPassword(textFieldPassword.getText());
        try {
            clubOwnerBean.setEmail(textFieldEmail.getText());
            RegisterAppController.registerClubOwner(clubOwnerBean);
            ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml");
        } catch (EmptyInputException | EmailNotValidException | SystemException e) {
            MyNotification.createNotification(e);
        }


    }

    public void setAll(String[] personalInfo) throws EmptyInputException, WrongInputTypeException {
        clubOwnerBean = new ClubOwnerBean();
        clubOwnerBean.setName(personalInfo[0]);
        clubOwnerBean.setAddress(personalInfo[1]);
        clubOwnerBean.setCity(personalInfo[2]);
        clubOwnerBean.setDiscountVIP(personalInfo[3]);
    }
}