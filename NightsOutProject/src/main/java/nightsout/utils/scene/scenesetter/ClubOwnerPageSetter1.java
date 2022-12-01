package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ClubOwnerPageGUIController1;
import nightsout.control.guicontroller.interface1.UserPageGUIController1;
import nightsout.control.guicontroller.interface1.ViewClubOwnerPageGUIController1;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.UserBean;

import java.sql.SQLException;

public class ClubOwnerPageSetter1 {

    private ClubOwnerPageSetter1() {
        //ignored
    }
    public static void setterItem(ClubOwnerBean clubOwnerBean, ViewClubOwnerPageGUIController1 viewClubOwnerPageGUIController1) throws SQLException {
        viewClubOwnerPageGUIController1.setAll(clubOwnerBean);
    }

    public static void setterCulo(ClubOwnerPageGUIController1 clubOwnerPageGUIController1) throws SQLException {
        clubOwnerPageGUIController1.setAllCulo();
    }
}
