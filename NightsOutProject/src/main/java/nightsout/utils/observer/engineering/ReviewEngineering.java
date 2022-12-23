package nightsout.utils.observer.engineering;

import nightsout.control.appcontroller.UserPageAppController;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.GenericBeanList;
import nightsout.utils.observer.Observer;

public class ReviewEngineering {

    private ReviewEngineering() {
        //ignored
    }

    public static void eventsToReview(Observer observer, int idUser) throws SystemException {
        GenericBeanList list = new GenericBeanList(observer);
        list.addEventsToList(UserPageAppController.searchEndedEventsByIdUser(idUser));
    }
}
