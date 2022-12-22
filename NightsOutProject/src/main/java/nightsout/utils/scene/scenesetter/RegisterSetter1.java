package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ConcludeRegisterClubOwnerGUIController1;
import nightsout.control.guicontroller.interface1.ConcludeRegisterUserGUIController1;
import nightsout.control.guicontroller.interface1.CreateEventGUIController1;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.UserBean1;

public class RegisterSetter1 {

    private RegisterSetter1() {
        //ignored
    }

    public static void setterClubOwner(ClubOwnerBean1 clubOwnerBean1, ConcludeRegisterClubOwnerGUIController1 concludeRegisterClubOwnerGUIController1) {
        concludeRegisterClubOwnerGUIController1.setAll(clubOwnerBean1);
    }

    public static void setterUser(UserBean1 userBean, ConcludeRegisterUserGUIController1 concludeRegisterUserGUIController1) { concludeRegisterUserGUIController1.setAll(userBean); }

    public static void setterCreateEvent(CreateEventGUIController1 createEventGUIController1) { createEventGUIController1.setAll(); }
}
