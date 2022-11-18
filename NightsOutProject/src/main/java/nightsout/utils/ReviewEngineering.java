package nightsout.utils;

import nightsout.control.appcontroller.CheckRequestsAppController;
import nightsout.control.appcontroller.UserPageAppController;
import nightsout.utils.bean.RequestBean;

import java.sql.SQLException;
import java.util.List;

public class ReviewEngineering {

    private ReviewEngineering() {
        //ignored
    }

    public static void endedBookedEvents(Observer observer, int idUser) throws SQLException {
        GenericBeanList list = new GenericBeanList(observer);
        list.addEventsToList(UserPageAppController.searchEndedEventsByIdUser(idUser));
    }
}
