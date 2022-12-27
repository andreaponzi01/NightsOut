package nightsout.utils.scene.initPage2;

import nightsout.control.guicontroller.interface2.EventPageFromUserGUIController2;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.exception.myexception.SystemException;

public class InitEventPage2 {

    private InitEventPage2() {
        //ignored
    }

    public static void setterUser(EventBean2 eventBean, EventPageFromUserGUIController2 eventPageFromUserGUIController2) throws SystemException {
        eventPageFromUserGUIController2.setAll(eventBean);
    }
    /*
    public static void setterCO( EventBean eventBean, EventPageFromCOGUIController2 eventPageFromCOGUIController2) throws SystemException {
        eventPageFromCOGUIController2.setAll(eventBean);
    }
     */
}
