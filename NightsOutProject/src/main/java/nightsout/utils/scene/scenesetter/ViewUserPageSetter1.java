package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ViewUserPageFromCOGUIController1;
import nightsout.control.guicontroller.interface1.ViewUserPageFromUserGUIController1;
import nightsout.utils.bean.UserBean;

public class ViewUserPageSetter1 {

    private ViewUserPageSetter1() {
        //ignored
    }

    public static void setterCO(UserBean userBean, ViewUserPageFromCOGUIController1 viewuserGUIController1) {
        viewuserGUIController1.setAll(userBean);
    }

    public static void setterUser(UserBean userBean, ViewUserPageFromUserGUIController1 viewuserGUIController1) {
        viewuserGUIController1.setAll(userBean);
    }


}
