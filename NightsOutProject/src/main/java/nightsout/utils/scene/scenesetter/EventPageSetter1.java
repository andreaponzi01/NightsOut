package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.*;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;

import java.sql.SQLException;

public class EventPageSetter1 {

    private EventPageSetter1() {
        //ignored
    }
    public static void setter1(UserBean userBean, EventBean eventBean, String oldInput, EventPageSendRequestGUIController1 eventPageSendRequestGUIController1) {
        eventPageSendRequestGUIController1.setAll(userBean, eventBean, oldInput);
    }
    public static void setter2(UserBean userBean, EventBean eventBean, String oldInput, EventPageAlreadySentRequestGUIController1 eventPageAlreadySentRequestGUIController1) {
        eventPageAlreadySentRequestGUIController1.setAll(userBean, eventBean, oldInput);
    }

    public static void setter3(UserBean userBean, EventBean eventBean, EventPageAlreadySentRequestGUIController1 eventPageAlreadySentRequestGUIController1) {
        eventPageAlreadySentRequestGUIController1.setAll(userBean, eventBean, "");
    }

    public static void setterClubOwner(ClubOwnerBean clubOwnerBean, EventBean eventBean, EventPageClubOwnerGUIController1 eventPageClubOwnerGUIController1) throws SQLException {
        eventPageClubOwnerGUIController1.setAll(clubOwnerBean, eventBean);
    }
    public static void setterUser(UserBean userBean, EventBean eventBean, EventPageUserGUIController1 eventPageUserGUIController1) throws SQLException {
        eventPageUserGUIController1.setAll(userBean, eventBean);
    }
}
