package nightsout.control.guicontroller.interface1.clubowner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.exception.myexception.WrongInputRangeException;
import nightsout.utils.exception.myexception.WrongInputTypeException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage1;
import nightsout.utils.scene.switchpage.SwitchPage;

public class RegisterClubOwnerGUIController1 {

    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldCity;
    @FXML
    private TextField textFieldAddress;
    @FXML
    private TextField textFieldDiscount;

    private SwitchPage switchPage = new SwitchPage();
    private SwitchAndSetPage1 switchAndSetPage1 = new SwitchAndSetPage1();

    @FXML
    protected void backToChoice(ActionEvent actionEvent) { switchPage.replaceScene(actionEvent, "/RegisterChoice1.fxml"); }
    @FXML
    protected void goToConcludeRegister(ActionEvent actionEvent) {

        try {
            ClubOwnerBean1 clubOwnerBean1 = new ClubOwnerBean1();
            clubOwnerBean1.setName(textFieldName.getText());
            clubOwnerBean1.setAddress(textFieldAddress.getText());
            clubOwnerBean1.setCity(textFieldCity.getText());
            clubOwnerBean1.setDiscountVIP(textFieldDiscount.getText());
            switchAndSetPage1.switchAndSetSceneClubOwner(actionEvent, "/ConcludeRegisterClubOwner1.fxml", clubOwnerBean1);
        } catch (WrongInputTypeException | EmptyInputException | SystemException | WrongInputRangeException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}