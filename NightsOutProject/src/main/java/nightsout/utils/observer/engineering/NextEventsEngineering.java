package nightsout.utils.observer.engineering;

import nightsout.control.appcontroller.UserPageAppController;
import nightsout.utils.observer.GenericBeanList;
import nightsout.utils.observer.Observer;

import java.sql.SQLException;

public class NextEventsEngineering {

    private NextEventsEngineering() {
        //ignore
    }

    public static void nextEvents(Observer observer, int idUser) throws SQLException {
        GenericBeanList list= new GenericBeanList(observer);
        list.addEventsToList(UserPageAppController.searchNextEventsByIdUser(idUser));
    }
}
