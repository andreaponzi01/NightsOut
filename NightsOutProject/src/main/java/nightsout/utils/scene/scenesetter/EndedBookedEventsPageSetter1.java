package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.EndedBookedEventsGUIController1;
import nightsout.control.guicontroller.interface1.UserPageGUIController1;
import nightsout.utils.bean.UserBean;
import nightsout.utils.exception.myexception.SystemException;

import java.sql.SQLException;

public class EndedBookedEventsPageSetter1 {

    private EndedBookedEventsPageSetter1() {
        //ignored
    }

    public static void setter(EndedBookedEventsGUIController1 endedBookedEventsGUIController1) throws SQLException, SystemException {
        endedBookedEventsGUIController1.setAll();
    }



}
