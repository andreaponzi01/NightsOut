package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ConcludeRegisterClubOwnerGUIController1;
import nightsout.control.guicontroller.interface1.ConcludeRegisterUserGUIController1;
import nightsout.control.guicontroller.interface1.CreateEventGUIController1;
import nightsout.utils.bean.ClubOwnerBean;

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

    public static void setterCreateEvent(ClubOwnerBean clubOwnerBean, CreateEventGUIController1 createEventGUIController1) {
        createEventGUIController1.setAll(clubOwnerBean);
    }
}
