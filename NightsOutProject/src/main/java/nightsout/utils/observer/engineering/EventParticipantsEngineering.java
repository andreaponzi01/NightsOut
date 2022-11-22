package nightsout.utils.observer.engineering;

import nightsout.control.appcontroller.EventPageAppController;
import nightsout.utils.observer.GenericBeanList;
import nightsout.utils.observer.Observer;

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
