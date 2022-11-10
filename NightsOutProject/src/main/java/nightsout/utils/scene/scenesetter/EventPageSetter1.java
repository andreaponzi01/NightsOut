package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.EventPageAlreadySentRequestGUIController1;
import nightsout.control.guicontroller.interface1.EventPageSendRequestGUIController1;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;

public class EventPageSetter1 {

    private EventPageSetter1() {
        //ignored
    }
    public static void setter1(UserBean userBean, EventBean eventBean, String oldInput, EventPageSendRequestGUIController1 eventPageSendRequestGUIController1) {
        eventPageSendRequestGUIController1.setAll(userBean, eventBean, oldInput);
    }
    public static void setter2(UserBean userBean, EventBean eventBean, String oldInput, EventPageAlreadySentRequestGUIController1 eventPageAlreadySentRequestGUIController1) {
        eventPageAlreadySentRequestGUIController1.setAll(userBean, eventBean, oldInput);
    }
}
