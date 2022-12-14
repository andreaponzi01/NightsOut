package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.UserPageGUIController1;
import nightsout.utils.exception.myexception.SystemException;

public class UserPageSetter1 {

    private UserPageSetter1() {
        //ignored
    }

    public static void setter(UserPageGUIController1 userPageGUIController1) throws SystemException {
        userPageGUIController1.setAll();
    }

}
