package nightsout.utils.observer.engineering;

import nightsout.control.appcontroller.ClubOwnerPageAppController;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.GenericBeanList;
import nightsout.utils.observer.Observer;

public class CreatedEventsEngineering {

    private CreatedEventsEngineering() {
        //ignore
    }

    public static void createdEvents(Observer observer, int idClubOwner) throws SystemException {
        GenericBeanList list= new GenericBeanList(observer);
        list.addEventsToList(ClubOwnerPageAppController.searchCreatedEventsByIdClubOwner(idClubOwner));
    }
}
