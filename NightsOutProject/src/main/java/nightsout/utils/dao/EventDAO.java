package nightsout.utils.dao;

import nightsout.model.EventModel;
import nightsout.utils.db.CRUD;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.db.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

public class EventDAO {

    public static void createEvent(EventModel eventModel) {
        Statement stm= null;
        try{

            stm= MySqlConnection.tryConnect();
            LocalTime time = LocalTime.of(eventModel.getHours(), eventModel.getMinutes(), 0);
            CRUD.insertEvent(eventModel.getIdClubOwner(), eventModel.getName(), eventModel.getEventDate().toString(), Time.valueOf(time).toString(), eventModel.getDuration(), eventModel.getPrice(), stm);

        }catch (/*MysqlConnectionFailed |*/ SQLException /*| FileNotFoundException*/ m) {
            // ErrorHandler.getInstance().handleException(m);
            m.printStackTrace();
        }
    }

    public static ArrayList<EventModel> getEventByName(String name) {

            ArrayList<EventModel> list = null;
            Statement stm = null;
            EventModel eventModel = null;
            try {
                list = new ArrayList<EventModel>();
                stm = MySqlConnection.tryConnect();

                ResultSet rs = Query.searchEventsByName(stm, name);
                rs.next();

                do {
                    eventModel = new EventModel();
                    eventModel.setName(rs.getString(5));
                    eventModel.setIdEvent(rs.getInt(1));
                    //Aggiungere altre set

                    list.add(eventModel);

                } while(rs.next());

                return list;

            } catch (/*MysqlConnectionFailed |*/ SQLException e){
                // ErrorHandler.getInstance().handleException(e);
                e.printStackTrace();
            }
            return list;
    }

}
