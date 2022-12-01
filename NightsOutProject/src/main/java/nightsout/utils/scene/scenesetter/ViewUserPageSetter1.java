package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ViewUserPageFromCOGUIController1;
import nightsout.control.guicontroller.interface1.ViewUserPageFromUserGUIController1;
import nightsout.utils.bean.UserBean;

import java.sql.SQLException;

public class ViewUserPageSetter1 {

    private ViewUserPageSetter1() {
        //ignored
    }


    /*
    public static void setterSimple(UserBean userBean, EventBean eventBean, String oldFxml, String previousOldFxml, ViewUserPageGUIController1 userGUIController1) throws SQLException {
        userGUIController1.setAll(userBean, eventBean, oldFxml, previousOldFxml);
    }

    public static void setterCulo(UserPageGUIController1 userPageGUIController1) throws SQLException {
        userPageGUIController1.setAllCulo();
    }

    public static void setterClubOwner(UserBean userBean, String oldFxml, ViewUserPageGUIController1 viewuserGUIController1) throws SQLException {
        viewuserGUIController1.setAll(userBean, oldFxml);
    }

     */


    public static void setterCO(UserBean userBean, ViewUserPageFromCOGUIController1 viewuserGUIController1) throws SQLException {
        viewuserGUIController1.setAll(userBean);
    }

    public static void setterUser(UserBean userBean, ViewUserPageFromUserGUIController1 viewuserGUIController1) throws SQLException {
        viewuserGUIController1.setAll(userBean);
    }


}
