package nightsout.utils.scene.initpage2;

import nightsout.control.guicontroller.interface2.ViewUserPageGUIController2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.myexception.SystemException;

public class InitViewUserPage2 {

    private InitViewUserPage2() {
        //ignored
    }

    public static void setter(UserBean2 userBean, ViewUserPageGUIController2 viewUserPageGUIController2) throws SystemException {
        viewUserPageGUIController2.setAll(userBean);
    }
}
