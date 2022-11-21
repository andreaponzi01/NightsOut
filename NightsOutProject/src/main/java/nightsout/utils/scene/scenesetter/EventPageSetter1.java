package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.EventPageDecoratorGUIController1;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ProfileBean;

import java.sql.SQLException;

public class EventPageSetter1 {

    private EventPageSetter1() {
        //ignored
    }

    public static void setterDecorator(ProfileBean profileBean, EventBean eventBean, String oldFxml, EventPageDecoratorGUIController1 eventPageDecoratorGUIController1) throws SQLException {
        eventPageDecoratorGUIController1.setAll(profileBean, eventBean, oldFxml);
    }
}
