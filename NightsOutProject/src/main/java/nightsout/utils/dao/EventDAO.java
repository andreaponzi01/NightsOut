package nightsout.utils.dao;

import nightsout.model.EventModel;
import nightsout.utils.db.CRUD;
import nightsout.utils.db.MySqlConnection;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;

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
}
