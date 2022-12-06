package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.EventPageDecoratorCOGUIController1;
import nightsout.control.guicontroller.interface1.EventPageDecoratorUserGUIController1;
import nightsout.utils.bean.EventBean;
import nightsout.utils.exception.myexception.SystemException;

import java.sql.SQLException;

public class EventPageSetter1 {

    private EventPageSetter1() {
        //ignored
    }

    public static void setterDecoratorUser( EventBean eventBean, EventPageDecoratorUserGUIController1 eventPageDecoratorGUIController1) throws SQLException, SystemException {
        eventPageDecoratorGUIController1.setAll(eventBean);
    }
    public static void setterDecoratorCO( EventBean eventBean, EventPageDecoratorCOGUIController1 eventPageDecoratorGUIController1) throws SQLException, SystemException {
        eventPageDecoratorGUIController1.setAll(eventBean);
    }
}
