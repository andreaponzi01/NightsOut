package nightsout.utils.dao;

import nightsout.model.EventModel;
import nightsout.utils.db.CRUD;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.db.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    private EventDAO() {
        //ignored
    }

    public static void createEvent(EventModel eventModel) {
        Statement stm= null;
        try{

            stm= MySqlConnection.tryConnect();
            CRUD.insertEvent(eventModel.getIdClubOwner(), eventModel.getName(), eventModel.getEventDate().toString(), eventModel.getTime().toString(), eventModel.getDuration(), eventModel.getPrice(), stm);

        }catch (/*MysqlConnectionFailed |*/ SQLException /*| FileNotFoundException*/ m) {
            // ErrorHandler.getInstance().handleException(m);
            m.printStackTrace();
        }
    }

    public static List<EventModel> getEventByName(String name) {

        ArrayList<EventModel> list = null;
            PreparedStatement preparedStatement = null;
            EventModel eventModel = null;
            try {
                list = new ArrayList<>();
                preparedStatement = Query.searchEventsByName(name);
                ResultSet rs = preparedStatement.executeQuery();
                rs.next();

                do {
                    eventModel = new EventModel();
                    eventModel.setName(rs.getString(5));
                    eventModel.setIdEvent(rs.getInt(1));
                    eventModel.setIdClubOwner(rs.getInt(2));
                    eventModel.setTime(rs.getTime(10).toLocalTime());
                    eventModel.setPrice(rs.getDouble(4));
                    eventModel.setDuration(rs.getInt(7));
                    eventModel.setEventDate(rs.getDate(6).toLocalDate());

                    list.add(eventModel);

                } while(rs.next());

                preparedStatement.close();
                return list;

            } catch (/*MysqlConnectionFailed |*/ SQLException e){
                // ErrorHandler.getInstance().handleException(e);
                e.printStackTrace();
            }
            return list;
    }

}
