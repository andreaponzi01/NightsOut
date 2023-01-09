package nightsout.control.guicontroller.interface1.clubowner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.exception.myexception.WrongInputRangeException;
import nightsout.utils.exception.myexception.WrongInputTypeException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage1;
import nightsout.utils.scene.switchpage.SwitchPage;

public class RegisterClubOwnerGUIController1 {

    @FXML
    Button buttonNextStep;
    @FXML
    Button buttonBack;
    @FXML
    TextField textFieldName;
    @FXML
    TextField textFieldCity;
    @FXML
    TextField textFieldAddress;
    @FXML
    TextField textFieldDiscount;

    @FXML
    protected void backToChoice(ActionEvent actionEvent) { SwitchPage.replaceScene(actionEvent, "/RegisterChoice1.fxml"); }
    @FXML
    protected void goToConcludeRegister(ActionEvent actionEvent) {

        try {
            ClubOwnerBean1 clubOwnerBean1 = new ClubOwnerBean1();
            clubOwnerBean1.setName(textFieldName.getText());
            clubOwnerBean1.setAddress(textFieldAddress.getText());
            clubOwnerBean1.setCity(textFieldCity.getText());
            clubOwnerBean1.setDiscountVIP(textFieldDiscount.getText());
            SwitchAndSetPage1.switchAndSetSceneClubOwner(actionEvent, "/ConcludeRegisterClubOwner1.fxml", clubOwnerBean1);
        } catch (WrongInputTypeException | EmptyInputException | SystemException | WrongInputRangeException e) {
            ExceptionHandler.handleException(e);
        }
    }
}