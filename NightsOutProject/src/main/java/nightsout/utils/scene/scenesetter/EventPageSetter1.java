package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.EventPageDecoratorCOGUIController1;
import nightsout.control.guicontroller.interface1.EventPageDecoratorUserGUIController1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.exception.myexception.SystemException;

public class EventPageSetter1 {

    private EventPageSetter1() {
        //ignored
    }

    public static void setterDecoratorUser(EventBean1 eventBean1, EventPageDecoratorUserGUIController1 eventPageDecoratorGUIController1) throws SystemException {
        eventPageDecoratorGUIController1.setAll(eventBean1);
    }
    public static void setterDecoratorCO(EventBean1 eventBean1, EventPageDecoratorCOGUIController1 eventPageDecoratorGUIController1) throws SystemException {
        eventPageDecoratorGUIController1.setAll(eventBean1);
    }
}
