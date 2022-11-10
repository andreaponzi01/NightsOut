package nightsout.utils.dao;

import nightsout.model.EventModel;
import nightsout.model.ManageRequestModel;
import nightsout.model.RequestModel;
import nightsout.model.UserModel;
import nightsout.utils.db.CRUD;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.db.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RequestDAO {

    private RequestDAO() {
        //ignored
    }
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
        RequestModel requestModel = null;
        PreparedStatement preparedStatement = null;

        try{
            System.out.println(userModel.getId() + " " + eventModel.getIdEvent());
            preparedStatement = Query.searchRequest(userModel.getId(), eventModel.getIdEvent());
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            requestModel = new RequestModel();
            requestModel.setIdRequest(rs.getInt(1));
            requestModel.setIdUser(rs.getInt(2));
            requestModel.setIdEvent(rs.getInt(4));
            requestModel.setStatus(rs.getString(3));

            preparedStatement.close();
            return requestModel;


        }catch (/*MysqlConnectionFailed |*/ SQLException /*| FileNotFoundException*/ m) {
            // ErrorHandler.getInstance().handleException(m);
            m.printStackTrace();
        }

        return requestModel;
    }

    public static List<ManageRequestModel> getRequestsByIdClubOwner(int idClubOwner) {
        List<ManageRequestModel> list = null;
        PreparedStatement preparedStatement = null;
        ManageRequestModel manageRequestModel = null ;

        try {
            list = new ArrayList<>();

            preparedStatement = Query.searchRequestsByIdClubOwner(idClubOwner);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            do {
                //R.idRequest, R.status, U.name, U.surname, E.name
                manageRequestModel = new ManageRequestModel();
                manageRequestModel.setIdRequest(rs.getInt(1));
                manageRequestModel.setRequestDate(rs.getDate(2));
                manageRequestModel.setUserName(rs.getString(3));
                manageRequestModel.setUserSurname(rs.getString(4));
                manageRequestModel.setEventName(rs.getString(5));

                list.add(manageRequestModel);

            } while(rs.next());

            preparedStatement.close();
            return list;

        } catch (/*MysqlConnectionFailed |*/ SQLException e){
            // ErrorHandler.getInstance().handleException(e);
            e.printStackTrace();
        }
        return list;
    }

    public static List<RequestModel> getRequestsByIdUser(int idUser) {
        List<RequestModel> list = null;
        PreparedStatement preparedStatement = null;
        RequestModel requestModel = null ;

        try {
            list = new ArrayList<>();

            preparedStatement = Query.searchRequestsByIdUser(idUser);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            do {
                //R.idRequest, R.status, U.name, U.surname, E.name
                requestModel = new RequestModel();
                requestModel.setIdRequest(rs.getInt(1));
                requestModel.setIdEvent(rs.getInt(4));
                requestModel.setIdUser(rs.getInt(2));
                requestModel.setStatus(rs.getString(3));

                list.add(requestModel);

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
