package nightsout.utils.scene.initPage1;

import nightsout.control.guicontroller.interface1.ConcludeRegisterClubOwnerGUIController1;
import nightsout.control.guicontroller.interface1.ConcludeRegisterUserGUIController1;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.UserBean1;

public class RegisterSetter1 {

    private RegisterSetter1() {
        //ignored
    }

    public static void setterClubOwner(ClubOwnerBean1 clubOwnerBean, ConcludeRegisterClubOwnerGUIController1 concludeRegisterClubOwnerGUIController1) {concludeRegisterClubOwnerGUIController1.setAll(clubOwnerBean);}
    public static void setterUser(UserBean1 userBean, ConcludeRegisterUserGUIController1 concludeRegisterUserGUIController1) { concludeRegisterUserGUIController1.setAll(userBean); }
}
