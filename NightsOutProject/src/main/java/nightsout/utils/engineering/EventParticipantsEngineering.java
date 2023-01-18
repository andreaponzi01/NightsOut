package nightsout.utils.engineering;

import nightsout.control.appcontroller.EventPageAppController;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.GenericBeanList;
import nightsout.utils.observer.Observer;

public class EventParticipantsEngineering {

    public void eventParticipants(Observer observer, int idEvent) throws SystemException {

        EventPageAppController controller = new EventPageAppController();
        GenericBeanList list= new GenericBeanList(observer);
        list.addUsersToList(controller.searchUsersByIdEvent(idEvent));
    }
}
