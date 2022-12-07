package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.EndedBookedEventsGUIController1;
import nightsout.utils.exception.myexception.SystemException;

public class EndedBookedEventsPageSetter1 {

    private EndedBookedEventsPageSetter1() {
        //ignored
    }

    public static void setter(EndedBookedEventsGUIController1 endedBookedEventsGUIController1) throws SystemException {
        endedBookedEventsGUIController1.setAll();
    }



}
