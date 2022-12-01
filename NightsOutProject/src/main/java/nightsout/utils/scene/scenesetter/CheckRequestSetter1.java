package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.CheckRequestsGUIController1;
import nightsout.utils.bean.UserBean;

import java.sql.SQLException;

public class CheckRequestSetter1 {
    public static void setter( CheckRequestsGUIController1 checkRequestsGUIController1) throws SQLException {
        checkRequestsGUIController1.setAll();
    }
}
