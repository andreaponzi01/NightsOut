package nightsout.utils.observer.engineering;

import nightsout.control.appcontroller.UserPageAppController;
import nightsout.utils.observer.GenericBeanList;
import nightsout.utils.observer.Observer;

import java.sql.SQLException;

public class ReviewEngineering {

    private ReviewEngineering() {
        //ignored
    }

    public static void endedBookedEvents(Observer observer, int idUser) throws SQLException {
        GenericBeanList list = new GenericBeanList(observer);
        list.addEventsToList(UserPageAppController.searchEndedEventsByIdUser(idUser));
    }
}
