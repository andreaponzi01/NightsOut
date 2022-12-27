package nightsout.utils.scene.initPage2;

import nightsout.control.guicontroller.interface2.ViewUserPageFromCOGUIController2;
import nightsout.control.guicontroller.interface2.ViewUserPageFromUserGUIController2;
import nightsout.utils.bean.UserBean;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.myexception.SystemException;

public class InitViewUserPage2 {

    private InitViewUserPage2() {
        //ignored
    }

    public static void setterCO(UserBean2 userBean, ViewUserPageFromCOGUIController2 viewUserPageFromCOGUIController2) throws SystemException {
        viewUserPageFromCOGUIController2.setAll(userBean);
    }


    public static void setterUser(UserBean userBean, ViewUserPageFromUserGUIController2 viewUserPageFromUserGUIController2) throws SystemException {
        viewUserPageFromUserGUIController2.setAll(userBean);
    }
}
