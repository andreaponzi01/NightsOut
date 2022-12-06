package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ViewUserPageFromUserGUIController1;
import nightsout.control.guicontroller.interface1.UserPageGUIController1;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.exception.myexception.SystemException;

import java.sql.SQLException;

public class UserPageSetter1 {

    private UserPageSetter1() {
        //ignored
    }

    public static void setterCulo(UserPageGUIController1 userPageGUIController1) throws SQLException, SystemException {
        userPageGUIController1.setAllCulo();
    }

}
