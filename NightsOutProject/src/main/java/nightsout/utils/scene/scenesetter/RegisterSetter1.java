package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ConcludeRegisterClubOwnerGUIController1;
import nightsout.control.guicontroller.interface1.ConcludeRegisterUserGUIController1;
import nightsout.control.guicontroller.interface1.CreateEventGUIController1;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.UserBean;

public class RegisterSetter1 {

    private RegisterSetter1() {
        //ignored
    }

    public static void setterClubOwner(ClubOwnerBean clubOwnerBean, ConcludeRegisterClubOwnerGUIController1 concludeRegisterClubOwnerGUIController1) {
        concludeRegisterClubOwnerGUIController1.setAll(clubOwnerBean);
    }

    public static void setterUser(UserBean userBean, ConcludeRegisterUserGUIController1 concludeRegisterUserGUIController1) { concludeRegisterUserGUIController1.setAll(userBean); }

    public static void setterCreateEvent(CreateEventGUIController1 createEventGUIController1) { createEventGUIController1.setAll(); }
}
