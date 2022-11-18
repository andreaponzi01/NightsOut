package nightsout.utils;

import nightsout.control.appcontroller.ClubOwnerPageAppController;
import nightsout.control.appcontroller.UserPageAppController;

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
