package nightsout.utils.scenes.interface1;

import nightsout.control.guicontroller.interface1.ConcludeRegisterClubOwnerGUIController1;

public class RegisterSetter1 {

    private RegisterSetter1() {
        //ignored
    }

    public static void setter(String[] personalInfo, String type, ConcludeRegisterClubOwnerGUIController1 concludeRegisterClubOwnerGUIController1) {
        concludeRegisterClubOwnerGUIController1.setAll(personalInfo);
    }

}
