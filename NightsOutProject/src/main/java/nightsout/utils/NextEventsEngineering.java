package nightsout.utils;

import nightsout.control.appcontroller.UserPageAppController;
import nightsout.utils.bean.EventBean;
import org.w3c.dom.events.Event;

import java.sql.SQLException;
import java.util.List;

public class NextEventsEngineering {

    private NextEventsEngineering() {
        //ignore
    }

    public static void nextEvents(Observer observer, int idUser) throws SQLException {
        GenericBeanList list= new GenericBeanList(observer);
        list.addEventsToList(UserPageAppController.searchNextEventsByIdUser(idUser));
    }
}
