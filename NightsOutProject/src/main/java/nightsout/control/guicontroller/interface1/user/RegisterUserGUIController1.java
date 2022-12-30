package nightsout.control.guicontroller.interface1.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.AdultException;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchPage;
import nightsout.utils.scene.switchpage.SwitchAndSetPage1;

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
    protected void backToChoice(ActionEvent actionEvent) { SwitchPage.replaceScene(actionEvent, "/Welcome1.fxml"); }
    @FXML
    protected void goToConcludeRegister(ActionEvent actionEvent) {

        try {
            UserBean1 userBean1 = new UserBean1();
            userBean1.setName(textFieldName.getText());
            userBean1.setSurname(textFieldSurname.getText());
            userBean1.setGender(radioFemale.isSelected() ? "Female" : "Male");
            userBean1.setBirthday(dateBirthday.getValue());
            SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
            replacer.switchAndSetSceneUser(actionEvent, "/ConcludeRegisterUser1.fxml", userBean1);
        } catch (EmptyInputException | SystemException | AdultException e) {
            CreateNotification.createNotification(e);
        }
    }
}
