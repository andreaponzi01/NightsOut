package nightsout.utils.scene.initpage2;

import nightsout.control.guicontroller.interface2.EventParticipantsGUIController2;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.exception.myexception.SystemException;

public class InitParticipantsPage2 {

    private InitParticipantsPage2() {
        //ignored
    }
    public static void setter(EventBean2 eventBean, EventParticipantsGUIController2 eventParticipantsGUIController2) throws SystemException {
        eventParticipantsGUIController2.setAll(eventBean);
    }
}
