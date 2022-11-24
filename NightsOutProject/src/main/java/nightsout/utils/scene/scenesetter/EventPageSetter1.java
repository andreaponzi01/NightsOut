package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.EventPageDecoratorGUIController1;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ProfileBean;
import nightsout.utils.bean.UserBean;

import java.sql.SQLException;

public class EventPageSetter1 {

    private EventPageSetter1() {
        //ignored
    }

    public static void setterDecorator(ProfileBean profileBean, EventBean eventBean, String oldFxml, EventPageDecoratorGUIController1 eventPageDecoratorGUIController1) throws SQLException {
        eventPageDecoratorGUIController1.setAll(profileBean, eventBean, oldFxml);
    }

    public static void setterDecorator2(UserBean userBean, ClubOwnerBean clubOwnerBean, EventBean eventBean, String oldFxml, String prevOldFxml, EventPageDecoratorGUIController1 eventPageDecoratorGUIController1) throws SQLException {
        eventPageDecoratorGUIController1.setAll2(userBean, clubOwnerBean, eventBean, oldFxml, prevOldFxml);
    }
}
