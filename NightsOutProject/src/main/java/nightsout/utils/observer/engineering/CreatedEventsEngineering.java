package nightsout.utils.observer.engineering;

import nightsout.control.appcontroller.ClubOwnerPageAppController;
import nightsout.utils.observer.GenericBeanList;
import nightsout.utils.observer.Observer;

import java.sql.SQLException;

public class CreatedEventsEngineering {

    private CreatedEventsEngineering() {
        //ignore
    }

    public static void createdEvents(Observer observer, int idClubOwner) throws SQLException {
        GenericBeanList list= new GenericBeanList(observer);
        list.addEventsToList(ClubOwnerPageAppController.searchCreatedEventsByIdClubOwner(idClubOwner));
    }
}
