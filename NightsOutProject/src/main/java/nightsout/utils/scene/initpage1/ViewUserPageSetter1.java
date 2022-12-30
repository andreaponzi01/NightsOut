package nightsout.utils.scene.initpage1;

import nightsout.control.guicontroller.interface1.clubowner.UserPageFromCOGUIController1;
import nightsout.control.guicontroller.interface1.user.UserPageFromUserGUIController1;
import nightsout.utils.bean.interface1.UserBean1;

public class ViewUserPageSetter1 {

    private ViewUserPageSetter1() {
        //ignored
    }

    public static void setterCO(UserBean1 userBean, UserPageFromCOGUIController1 viewuserGUIController1) {
        viewuserGUIController1.setAll(userBean);
    }
    public static void setterUser(UserBean1 userBean, UserPageFromUserGUIController1 viewuserGUIController1) {
        viewuserGUIController1.setAll(userBean);
    }


}
