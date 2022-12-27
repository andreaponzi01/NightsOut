package nightsout.utils.scene.initPage1;

import nightsout.control.guicontroller.interface1.ViewUserPageFromCOGUIController1;
import nightsout.control.guicontroller.interface1.ViewUserPageFromUserGUIController1;
import nightsout.utils.bean.UserBean;
import nightsout.utils.bean.interface1.UserBean1;

public class ViewUserPageSetter1 {

    private ViewUserPageSetter1() {
        //ignored
    }

    public static void setterCO(UserBean1 userBean, ViewUserPageFromCOGUIController1 viewuserGUIController1) {
        viewuserGUIController1.setAll(userBean);
    }
    public static void setterUser(UserBean1 userBean, ViewUserPageFromUserGUIController1 viewuserGUIController1) {
        viewuserGUIController1.setAll(userBean);
    }


}
