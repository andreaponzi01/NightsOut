package nightsout.utils.dao;

import nightsout.model.EventModel;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.SystemException;

import java.util.List;

public class EventDAO {

    Query query = new Query();
    public void createEvent(EventModel eventModel) throws SystemException {
        query.insertEvent(eventModel);
    }
    public List<EventModel> getEventsByName(String name) throws SystemException {
        return query.searchEventsByName(name);
    }
    public List<EventModel> getNextEventsByIdUser(int idUser) throws SystemException {
        return query.searchNextEventsByIdUser(idUser);
    }
    public List<EventModel> getCreatedEventsByIdClubOwner(int idClubOwner) throws SystemException {
        return query.searchCreatedEventsByIdClubOwner(idClubOwner);
    }
    public List<EventModel> getEndedEventsByIdUser(int idUser) throws SystemException {
            return query.searchEndedEventsByIdUser(idUser);
    }
    public EventModel getEventByIdEvent(int idEvent) throws SystemException {
           return query.searchEventByIdEvent(idEvent);
    }
}
