package nightsout.control.guicontroller.interface1;

import com.mysql.cj.log.Log;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import nightsout.control.appcontroller.LoginAppController;
import nightsout.utils.bean.interface1.LoginBean1;

public class LoginGUIController1 {

    @FXML
    TextField textFieldUsername;

    @FXML
    PasswordField passwordField;

    @FXML
    Button buttonLogin;

    @FXML
    CheckBox checkBoxClubOwner;

    @FXML
    void loginAction(ActionEvent ae) throws Exception {
        String type = "Free";

        if(checkBoxClubOwner.isSelected()) {
            type = "ClubOwner";
        }

      //  try {
            LoginBean1 loginBean = new LoginBean1(textFieldUsername.getText(), passwordField.getText(), type);
            LoginAppController.login(loginBean);
            /*
            ReplaceSceneAndInitializePage rsip = new ReplaceSceneAndInitializePage();
            if (type == 1) {
                rsip.replaceSceneAndInitializePage(ae, "/JFX1/JFX1ClubProfile.fxml");
            } else {
                rsip.replaceSceneAndInitializePage(ae, "/JFX1/JFX1UserProfile.fxml");
            }


        } catch (WrongPasswordException| SystemException e ){
            JFX1AlertCreator.createAlert(e);
        }

         */
    }


}
