package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
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
    private String[] personalInfo;
    //private LocalDate birthday;
    private void setPersonalInfo(){

        String name = textFieldName.getText();
        String surname = textFieldSurname.getText();
        String gender="";
        if(radioFemale.isSelected()){
            gender = "Female";
        }
        else{
            gender = "Male";
        }

        String birthday= dateBirthday.getValue().toString();
        System.out.println("\n\nmiao1\n\n");
        //birthday = dateBirthday.getValue();
        personalInfo = new String[]{name, surname, gender, birthday};
    }

    @FXML
    protected void backToChoice(ActionEvent actionEvent) { ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml"); }

    @FXML
    protected void goToConcludeRegister(ActionEvent actionEvent) throws SystemException {
        setPersonalInfo();
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneRegister(actionEvent,"/ConcludeRegisterUser1.fxml", personalInfo, "Free");
    }

}
