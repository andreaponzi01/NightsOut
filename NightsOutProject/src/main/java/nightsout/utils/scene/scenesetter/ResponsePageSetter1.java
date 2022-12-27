package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.EventReviewsClubOwnerGUIController1;
import nightsout.utils.exception.myexception.SystemException;

public class ResponsePageSetter1 {

    private ResponsePageSetter1() {
        //ignored
    }

    public static void setter(EventReviewsClubOwnerGUIController1 eventReviewsClubOwnerGUIController1) throws SystemException {
        eventReviewsClubOwnerGUIController1.setAll();
    }
}
