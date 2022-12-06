package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ManageRequestsGUIController1;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.exception.myexception.SystemException;

import java.sql.SQLException;

public class ManageRequestSetter1 {
    public static void setter(ManageRequestsGUIController1 manageRequestsGUIController1) throws SQLException, SystemException {
        manageRequestsGUIController1.setAll();
    }
}
