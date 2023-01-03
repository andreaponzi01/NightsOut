package nightsout.utils.scene.initpage1;

import nightsout.control.guicontroller.interface1.clubowner.EventPageCOGUIController1;
import nightsout.control.guicontroller.interface1.user.EventPageUserGUIController1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.exception.myexception.SystemException;

public class EventPageSetter1 {

    private EventPageSetter1() {
        //ignored
    }

    public static void setterDecoratorUser( EventBean1 eventBean, EventPageUserGUIController1 eventPageDecoratorGUIController1) throws SystemException {
        eventPageDecoratorGUIController1.setAll(eventBean);
    }
    public static void setterDecoratorCO(EventBean1 eventBean, EventPageCOGUIController1 eventPageDecoratorGUIController1) throws SystemException {
        eventPageDecoratorGUIController1.setAll(eventBean);
    }
}
