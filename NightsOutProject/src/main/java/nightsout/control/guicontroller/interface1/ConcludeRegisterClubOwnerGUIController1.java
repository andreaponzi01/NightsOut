package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.scenes.ReplaceScene;

public class ConcludeRegisterClubOwnerGUIController1 {

    private ClubOwnerBean clubOwnerBean;

    @FXML
    Button buttonBack, buttonSubmit;

    @FXML
    TextField textFieldUsername, textFieldPassword, textFieldEmail;

    @FXML
    protected void backToRegister(ActionEvent actionEvent) { ReplaceScene.replaceScene(actionEvent, "/RegisterClubOwner1.fxml"); }

    @FXML
    protected void goToWelcomePage(ActionEvent actionEvent) {
        clubOwnerBean.setUsername(textFieldUsername.getText());
        clubOwnerBean.setPassword(textFieldPassword.getText());
        clubOwnerBean.setEmail(textFieldEmail.getText());
        //CRUD
        ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml");
    }

    public void setAll(String[] personalInfo) {
        clubOwnerBean = new ClubOwnerBean();
        clubOwnerBean.setName(personalInfo[0]);
        clubOwnerBean.setAddress(personalInfo[1]);
        clubOwnerBean.setCity(personalInfo[2]);
        clubOwnerBean.setDiscountVIP(Integer.parseInt(personalInfo[3]));
    }
}