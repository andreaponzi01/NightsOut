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

public class RegisterUserGUIController1 {

    private String[] personalInfo;

    private void setPersonalInfo(){
        /*
        String name = textFieldName.getText();
        String address = textFieldAddress.getText();
        String city = textFieldCity.getText();
        String discount = textFieldDiscount.getText();

        personalInfo = new String[]{name, address, city, discount};
         */
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
