package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.CheckRequestsGUIController1;
import nightsout.utils.bean.UserBean;

public class CheckRequestSetter1 {
    public static void setter(UserBean userBean, CheckRequestsGUIController1 checkRequestsGUIController1) {
        checkRequestsGUIController1.setAll(userBean);
    }
}