package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.UserBean;
import nightsout.utils.exception.myexception.AdultException;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceScene;
import nightsout.utils.scene.ReplaceSceneDynamic1;

public class RegisterUserGUIController1 {

    @FXML
    Button buttonNextStep;
    @FXML
    Button buttonBack;
    @FXML
    TextField textFieldName;
    @FXML
    TextField textFieldSurname;
    @FXML
    RadioButton radioMale;
    @FXML
    RadioButton radioFemale;
    @FXML
    DatePicker dateBirthday;

    @FXML
    protected void backToChoice(ActionEvent actionEvent) { ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml"); }

    @FXML
    protected void goToConcludeRegister(ActionEvent actionEvent) {

        try {
            UserBean userBean = new UserBean();
            userBean.setName(textFieldName.getText());
            userBean.setSurname(textFieldSurname.getText());
            userBean.setGender(radioFemale.isSelected() ? "Female" : "Male");
            userBean.setBirthday(dateBirthday.getValue());
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneRegisterUser(actionEvent, "/ConcludeRegisterUser1.fxml", userBean);
        } catch (EmptyInputException | SystemException | AdultException e) {
            MyNotification.createNotification(e);
        }
    }


}
