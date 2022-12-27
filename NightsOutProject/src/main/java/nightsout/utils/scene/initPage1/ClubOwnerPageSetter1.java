package nightsout.utils.scene.initPage1;

import nightsout.control.guicontroller.interface1.ClubOwnerPageGUIController1;
import nightsout.utils.exception.myexception.SystemException;

public class ClubOwnerPageSetter1 {

    private ClubOwnerPageSetter1() {
        //ignored
    }

    public static void setter(ClubOwnerPageGUIController1 clubOwnerPageGUIController1) throws SystemException {
        clubOwnerPageGUIController1.setAll();
    }
}
