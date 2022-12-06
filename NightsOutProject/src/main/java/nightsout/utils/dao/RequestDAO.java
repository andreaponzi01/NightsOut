package nightsout.utils.dao;

import nightsout.control.guicontroller.MyNotification;
import nightsout.model.EventModel;
import nightsout.model.RequestModel;
import nightsout.model.UserModel;
import nightsout.utils.db.CRUD;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.db.Query;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.DBConnectionFailedException;
import nightsout.utils.exception.myexception.SystemException;

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
    public static void createRequest(UserModel userModel, EventModel eventModel) throws SystemException {
        Statement stm= null;
        try{
            stm= MySqlConnection.tryConnect();
            CRUD.insertRequest(userModel.getId(), eventModel.getIdEvent(), stm);

        }catch (SQLException /*| FileNotFoundException*/ e) {
            ExceptionHandler.handleException(e);
        } catch (DBConnectionFailedException e) {
            MyNotification.createNotification(e);
        }
    }

    public static RequestModel checkRequestStatus(UserModel userModel, EventModel eventModel) throws SystemException {
        RequestModel requestModel = null;
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = Query.searchRequest(userModel.getId(), eventModel.getIdEvent());
            ResultSet rs = preparedStatement.executeQuery();
            // Test???????
            assert rs != null;
            if (!rs.next()) {
                return null;
            }
            //rs.next();
            requestModel = new RequestModel();
            requestModel.setIdRequest(rs.getInt(1));
            requestModel.setIdUser(rs.getInt(2));
            requestModel.setIdEvent(rs.getInt(4));
            requestModel.setStatus(rs.getString(3));
            requestModel.setRequestDate(rs.getDate(5).toLocalDate());

            preparedStatement.close();
            return requestModel;


        }catch (SQLException /*| FileNotFoundException*/ e) {
            ExceptionHandler.handleException(e);
        }

        return requestModel;
    }

    public static List<RequestModel> getRequestsByIdClubOwner(int idClubOwner) throws SystemException {
        List<RequestModel> list = null;
        PreparedStatement preparedStatement = null;
        RequestModel requestModel = null;

        try {
            list = new ArrayList<>();

            preparedStatement = Query.searchRequestsByIdClubOwner(idClubOwner);
            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }
            //rs.next();

            do {
                requestModel = new RequestModel();
                requestModel.setIdRequest(rs.getInt(1));
                requestModel.setRequestDate(rs.getDate(5).toLocalDate());
                requestModel.setStatus(rs.getString(3));
                requestModel.setIdEvent(rs.getInt(4));
                requestModel.setIdUser(rs.getInt(2));

                list.add(requestModel);

            } while(rs.next());

            preparedStatement.close();
            return list;

        } catch (SQLException e){
            ExceptionHandler.handleException(e);
        }
        return list;
    }

    public static List<RequestModel> getRequestsByIdUser(int idUser) throws SystemException {
        List<RequestModel> list = null;
        PreparedStatement preparedStatement = null;
        RequestModel requestModel = null ;

        try {
            list = new ArrayList<>();

            preparedStatement = Query.searchRequestsByIdUser(idUser);
            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }
            //rs.next();
            do {
                //R.idRequest, R.status, U.name, U.surname, E.name
                requestModel = new RequestModel();
                requestModel.setIdRequest(rs.getInt(1));
                requestModel.setIdEvent(rs.getInt(4));
                requestModel.setIdUser(rs.getInt(2));
                requestModel.setStatus(rs.getString(3));
                requestModel.setRequestDate(rs.getDate(5).toLocalDate());

                list.add(requestModel);

            } while(rs.next());

            preparedStatement.close();
            return list;

        } catch (SQLException e){
            ExceptionHandler.handleException(e);
        }
        return list;
    }

    public static List<RequestModel> getPendingRequestsByIdUser(int idUser) throws SystemException {
        List<RequestModel> list = null;
        PreparedStatement preparedStatement = null;
        RequestModel requestModel = null ;

        try {
            list = new ArrayList<>();

            preparedStatement = Query.searchPendingRequestsByIdUser(idUser);
            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }
            //rs.next();
            do {
                //R.idRequest, R.status, U.name, U.surname, E.name
                requestModel = new RequestModel();
                requestModel.setIdRequest(rs.getInt(1));
                requestModel.setIdEvent(rs.getInt(4));
                requestModel.setIdUser(rs.getInt(2));
                requestModel.setStatus(rs.getString(3));
                requestModel.setRequestDate(rs.getDate(5).toLocalDate());

                list.add(requestModel);

            } while(rs.next());

            preparedStatement.close();
            return list;

        } catch (SQLException e){
            ExceptionHandler.handleException(e);
        }
        return list;
    }

    public static void UpdateRequestStatus(int idRequest,String status) throws SystemException {
        Statement stm= null;
        try{
            stm = MySqlConnection.tryConnect();
            CRUD.updateRequest(idRequest,status, stm);

        }catch (SQLException /*| FileNotFoundException*/ e) {
            ExceptionHandler.handleException(e);
        } catch (DBConnectionFailedException e) {
            MyNotification.createNotification(e);
        }
    }
}
