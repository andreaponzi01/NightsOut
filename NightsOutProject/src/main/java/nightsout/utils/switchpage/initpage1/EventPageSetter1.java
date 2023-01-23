package nightsout.utils.switchpage.initpage1;

import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.control.guicontroller.interface1.EventPageGUIController1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.exception.myexception.SystemException;

public class EventPageSetter1 {

    public void setter(EventBean1 eventBean, EventPageGUIController1 eventPageGUIController1) throws SystemException {
        eventPageGUIController1.setAll(eventBean);
    }

    public void setter(EventBean1 eventBean, JoinEventAppController joinEventAppController, EventPageGUIController1 eventPageGUIController1) throws SystemException {
        eventPageGUIController1.setAll(eventBean, joinEventAppController);
    }
}
