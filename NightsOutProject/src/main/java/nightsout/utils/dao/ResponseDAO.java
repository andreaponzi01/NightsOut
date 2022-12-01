package nightsout.utils.dao;

import nightsout.model.ResponseModel;
import nightsout.utils.db.Query;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResponseDAO {

    public ResponseDAO() {
        //ignore
    }

    public static void createResponse(ResponseModel responseModel) throws SystemException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = Query.insertResponse(responseModel);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException /*| FileNotFoundException*/ e) {
           ExceptionHandler.handleException(e);
        }
    }

    public static ResponseModel getResponseByIdReview(int idReview) throws SystemException {
        PreparedStatement preparedStatement=null;
        ResponseModel responseModel=null;
        try{
            preparedStatement = Query.searchResponseByIdReview(idReview);
            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.next()) {
                return responseModel;
            }

            responseModel = new ResponseModel();
            responseModel.setIdAnswer(rs.getInt(1));
            System.out.println("\n"+rs.getInt(1)+"\n");
            responseModel.setIdClubOwner(rs.getInt(2));
            responseModel.setReview(rs.getInt(3));
            responseModel.setResponse(rs.getString(4));
            preparedStatement.close();
            return responseModel;
        } catch (SQLException e){
           ExceptionHandler.handleException(e);
        }
        return responseModel;
    }

}
