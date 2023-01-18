package nightsout.utils.scene.initpage2;

import nightsout.control.guicontroller.interface2.EventPageGUIController2;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.exception.myexception.SystemException;

public class InitEventPage2 {

    public void setter(EventBean2 eventBean, EventPageGUIController2 eventPageGUIController2) throws SystemException {
        eventPageGUIController2.setAll(eventBean);
    }

}
