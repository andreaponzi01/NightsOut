package nightsout.utils.scene.scenesetter2;

import nightsout.control.guicontroller.interface1.UserPageGUIController1;
import nightsout.control.guicontroller.interface2.UserPageGUIController2;
import nightsout.utils.exception.myexception.SystemException;

public class UserPageSetter2 {

    private UserPageSetter2() {
        //ignored
    }

    public static void setter(UserPageGUIController2 userPageGUIController2) throws SystemException {
        userPageGUIController2.setAll();
    }

}
