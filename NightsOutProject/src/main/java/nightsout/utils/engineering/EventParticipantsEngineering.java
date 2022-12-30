package nightsout.utils.engineering;

import nightsout.control.appcontroller.EventPageAppController;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.GenericBeanList;
import nightsout.utils.observer.Observer;

public class EventParticipantsEngineering {

    private EventParticipantsEngineering() {
        //ignore
    }

    public static void eventParticipants(Observer observer, int idEvent) throws SystemException {

        GenericBeanList list= new GenericBeanList(observer);
        list.addUsersToList(EventPageAppController.searchUsersByIdEvent(idEvent));
    }
}
