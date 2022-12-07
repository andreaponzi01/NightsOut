package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.CheckPendingRequestsGUIController1;
import nightsout.control.guicontroller.interface1.CheckRifiutedRequestsGUIController1;

public class CheckRequestSetter1 {

    private CheckRequestSetter1() {
        // ignored
    }

    public static void setterPending(CheckPendingRequestsGUIController1 checkPendingRequestsGUIController1) {
        checkPendingRequestsGUIController1.setAll();
    }

    public static void setterRifiuted(CheckRifiutedRequestsGUIController1 checkRifiutedRequestsGUIController1) {
        checkRifiutedRequestsGUIController1.setAll();
    }
}
