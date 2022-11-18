package nightsout.utils;

import nightsout.control.appcontroller.ClubOwnerPageAppController;
import nightsout.control.appcontroller.EventPageAppController;
import nightsout.control.guicontroller.interface1.EventPageClubOwnerGUIController1;

import java.sql.SQLException;

public class EventParticipantsEngineering {

    private EventParticipantsEngineering() {
        //ignore
    }

    public static void eventParticipants(Observer observer, int idEvent) throws SQLException {
        GenericBeanList list= new GenericBeanList(observer);
        list.addUsersToList(EventPageAppController.searchUsersByIdEvent(idEvent));
    }
}
