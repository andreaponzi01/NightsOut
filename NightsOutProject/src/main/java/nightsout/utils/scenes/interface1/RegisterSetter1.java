package nightsout.utils.scenes.interface1;

import nightsout.control.guicontroller.interface1.ConcludeRegisterClubOwnerGUIController1;
import nightsout.control.guicontroller.interface1.ConcludeRegisterUserGUIController1;
import nightsout.control.guicontroller.interface1.CreateEventGUIController1;

public class RegisterSetter1 {

    private RegisterSetter1() {
        //ignored
    }

    public static void setterClubOwner(String[] personalInfo, ConcludeRegisterClubOwnerGUIController1 concludeRegisterClubOwnerGUIController1) {
        concludeRegisterClubOwnerGUIController1.setAll(personalInfo);
    }

    public static void setterUser(String[] personalInfo, ConcludeRegisterUserGUIController1 concludeRegisterUserGUIController1) {
        concludeRegisterUserGUIController1.setAll(personalInfo);
    }

    public static void setterCreateEvent(int idClubOwner, CreateEventGUIController1 createEventGUIController1) {
        createEventGUIController1.setIdClubOwner(idClubOwner);
    }
}
