package nightsout.utils.scene.initpage2;

import nightsout.control.guicontroller.interface2.clubowner.EventPageFromCOGUIController2;
import nightsout.control.guicontroller.interface2.user.EventPageFromUserGUIController2;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.exception.myexception.SystemException;

public class InitEventPage2 {

    private InitEventPage2() {
        //ignored
    }

    public static void setterUser(EventBean2 eventBean, EventPageFromUserGUIController2 eventPageFromUserGUIController2) throws SystemException {
        eventPageFromUserGUIController2.setAll(eventBean);
    }

    public static void setterCO(EventBean2 eventBean, EventPageFromCOGUIController2 eventPageFromCOGUIController2) throws SystemException {
        eventPageFromCOGUIController2.setAll(eventBean);
    }

}
