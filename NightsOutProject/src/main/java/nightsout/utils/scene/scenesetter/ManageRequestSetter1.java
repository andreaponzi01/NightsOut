package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ManageRequestsGUIController1;
import nightsout.utils.bean.ClubOwnerBean;

import java.sql.SQLException;

public class ManageRequestSetter1 {
    public static void setter(ClubOwnerBean clubOwnerBean, ManageRequestsGUIController1 manageRequestsGUIController1) throws SQLException {
        manageRequestsGUIController1.setAll(clubOwnerBean);
    }
}
