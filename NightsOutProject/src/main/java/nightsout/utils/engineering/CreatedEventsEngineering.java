package nightsout.utils.engineering;

import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.GenericBeanList;
import nightsout.utils.observer.Observer;

public class CreatedEventsEngineering {

    public void createdEvents(Observer observer, int idClubOwner) throws SystemException {

        GenericBeanList list = new GenericBeanList(observer);
        ClubOwnerPageEngineering clubOwnerPageEngineering = new ClubOwnerPageEngineering();
        list.addEventsToList(clubOwnerPageEngineering.searchCreatedEventsByIdClubOwner(idClubOwner));
    }
}
