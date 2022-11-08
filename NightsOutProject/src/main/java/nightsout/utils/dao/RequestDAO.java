package nightsout.utils.dao;

import nightsout.model.EventModel;
import nightsout.model.RequestModel;
import nightsout.model.UserModel;
import nightsout.utils.db.CRUD;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.db.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RequestDAO {

    public static void createRequest(UserModel userModel, EventModel eventModel) {
        Statement stm= null;
        try{
            stm= MySqlConnection.tryConnect();
            System.out.println(userModel.getId() + " " + eventModel.getIdEvent());
            CRUD.insertRequest(userModel.getId(), eventModel.getIdEvent(), stm);

        }catch (/*MysqlConnectionFailed |*/ SQLException /*| FileNotFoundException*/ m) {
            // ErrorHandler.getInstance().handleException(m);
            m.printStackTrace();
        }
    }

    public static RequestModel checkRequestStatus(UserModel userModel, EventModel eventModel) {
        Statement stm= null;
        RequestModel requestModel = null;

        try{
            stm= MySqlConnection.tryConnect();
            System.out.println(userModel.getId() + " " + eventModel.getIdEvent());
            ResultSet rs = Query.searchRequest(stm, userModel.getId(), eventModel.getIdEvent());
            rs.next();

            requestModel = new RequestModel();
            requestModel.setIdRequest(rs.getInt(1));
            requestModel.setIdUser(rs.getInt(2));
            requestModel.setIdEvent(rs.getInt(4));
            requestModel.setStatus(rs.getString(3));

            return requestModel;


        }catch (/*MysqlConnectionFailed |*/ SQLException /*| FileNotFoundException*/ m) {
            // ErrorHandler.getInstance().handleException(m);
            m.printStackTrace();
        }

        return requestModel;
    }

}
