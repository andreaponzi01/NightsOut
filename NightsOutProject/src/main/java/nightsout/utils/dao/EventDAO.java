package nightsout.utils.dao;

import nightsout.utils.exception.CreateNotification;
import nightsout.model.EventModel;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.DBConnectionFailedException;
import nightsout.utils.exception.myexception.SystemException;

import java.util.List;

public class EventDAO {

    private EventDAO() {
        //ignored
    }
    public static void createEvent(EventModel eventModel) throws SystemException {
        try{
            Query.insertEvent(eventModel);
        } catch (DBConnectionFailedException e) {
            CreateNotification.createNotification(e);
        }
    }
    public static List<EventModel> getEventsByName(String name) throws SystemException {
        return Query.searchEventsByName(name);
    }
    public static List<EventModel> getNextEventsByIdUser(int idUser) throws SystemException {
        return Query.searchNextEventsByIdUser(idUser);
    }
    public static List<EventModel> getCreatedEventsByIdClubOwner(int idClubOwner) throws SystemException {
        return Query.searchCreatedEventsByIdClubOwner(idClubOwner);
    }
    public static List<EventModel> getEndedEventsByIdUser(int idUser) throws SystemException {
            return Query.searchEndedEventsByIdUser(idUser);
    }
    public static EventModel getEventByIdEvent(int idEvent) throws SystemException {
           return Query.searchEventByIdEvent(idEvent);
    }
}
