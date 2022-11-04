package nightsout.utils.scenes.interface1;

import nightsout.control.guicontroller.interface1.UserPageGUIController1;
import nightsout.utils.bean.UserBean;

public class UserPageSetter1 {

    private UserPageSetter1() {
        //ignored
    }

    public static void setter(UserBean userBean, UserPageGUIController1 userPageGUIController1) {
        userPageGUIController1.setAll(userBean);
    }

}
