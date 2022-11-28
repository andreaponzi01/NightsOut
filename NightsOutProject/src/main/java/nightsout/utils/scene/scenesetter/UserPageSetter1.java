package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ViewUserPageGUIController1;
import nightsout.control.guicontroller.interface1.UserPageGUIController1;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;

import java.sql.SQLException;

public class UserPageSetter1 {

    private UserPageSetter1() {
        //ignored
    }

    public static void setter(UserBean userBean, UserPageGUIController1 userPageGUIController1) throws SQLException {
        userPageGUIController1.setAll(userBean);
    }

    public static void setterSimple(UserBean userBean, EventBean eventBean, String oldFxml, String previousOldFxml, ViewUserPageGUIController1 userGUIController1) throws SQLException {
        userGUIController1.setAll(userBean, eventBean, oldFxml, previousOldFxml);
    }

    public static void setterCulo(UserPageGUIController1 userPageGUIController1) throws SQLException {
        userPageGUIController1.setAllCulo();
    }


}
