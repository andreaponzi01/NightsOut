package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ConcludeRegisterClubOwnerGUIController1;
import nightsout.control.guicontroller.interface1.ConcludeRegisterUserGUIController1;
import nightsout.control.guicontroller.interface1.CreateEventGUIController1;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.WrongInputTypeException;

import java.sql.SQLException;

public class RegisterSetter1 {

    private RegisterSetter1() {
        //ignored
    }

    public static void setterClubOwner(String[] personalInfo, ConcludeRegisterClubOwnerGUIController1 concludeRegisterClubOwnerGUIController1) throws WrongInputTypeException, EmptyInputException {
        concludeRegisterClubOwnerGUIController1.setAll(personalInfo);
    }

    public static void setterUser(String[] personalInfo, ConcludeRegisterUserGUIController1 concludeRegisterUserGUIController1) throws EmptyInputException {
        concludeRegisterUserGUIController1.setAll(personalInfo);
    }

    public static void setterCreateEvent(CreateEventGUIController1 createEventGUIController1) throws SQLException {
        createEventGUIController1.setAll();
    }
}
