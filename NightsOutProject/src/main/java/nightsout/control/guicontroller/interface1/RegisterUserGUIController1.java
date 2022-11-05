package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import nightsout.utils.scenes.ReplaceScene;
import nightsout.utils.scenes.ReplaceSceneDynamic1;

import java.io.IOException;
import java.time.LocalDate;

public class RegisterUserGUIController1 {

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
    Button buttonNextStep, buttonBack;

    @FXML
    TextField textFieldName, textFieldSurname;

    @FXML
    RadioButton radioMale, radioFemale;

    @FXML
    DatePicker dateBirthday;

    @FXML
    protected void backToChoice(ActionEvent actionEvent) { ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml"); }

    @FXML
    protected void goToConcludeRegister(ActionEvent actionEvent) throws IOException {
        setPersonalInfo();
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneRegister(actionEvent,"/ConcludeRegisterUser1.fxml", personalInfo, "Free");
    }

}
