package nightsout.utils;

import nightsout.control.appcontroller.EventPageAppController;

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
