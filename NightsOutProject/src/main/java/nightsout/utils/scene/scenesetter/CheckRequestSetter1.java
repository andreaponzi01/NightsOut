package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.CheckPendingRequestsGUIController1;
import nightsout.control.guicontroller.interface1.CheckRifiutedRequestsGUIController1;
import nightsout.utils.exception.myexception.SystemException;

import java.sql.SQLException;

public class CheckRequestSetter1 {
    public static void setterPending(CheckPendingRequestsGUIController1 checkPendingRequestsGUIController1) throws SQLException, SystemException {
        checkPendingRequestsGUIController1.setAll();
    }

    public static void setterRifiuted( CheckRifiutedRequestsGUIController1 checkRifiutedRequestsGUIController1) throws SQLException, SystemException {
        checkRifiutedRequestsGUIController1.setAll();
    }
}
