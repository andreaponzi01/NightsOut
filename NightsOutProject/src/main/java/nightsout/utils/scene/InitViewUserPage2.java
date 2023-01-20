package nightsout.utils.scene;

import nightsout.control.guicontroller.interface2.ViewUserPageGUIController2;
import nightsout.utils.bean.interface2.UserBean2;

public class InitViewUserPage2 {

    public void setter(UserBean2 userBean, ViewUserPageGUIController2 viewUserPageGUIController2) {
        viewUserPageGUIController2.setAll(userBean);
    }
}
