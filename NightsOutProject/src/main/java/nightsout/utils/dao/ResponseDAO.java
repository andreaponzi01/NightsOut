package nightsout.utils.dao;

import nightsout.model.ResponseModel;
import nightsout.model.ReviewModel;
import nightsout.utils.db.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResponseDAO {

    public ResponseDAO() {
        //ignore
    }

    public static void createResponse(ResponseModel responseModel) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = Query.insertResponse(responseModel);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (/*MysqlConnectionFailed |*/ SQLException /*| FileNotFoundException*/ m) {
            // ErrorHandler.getInstance().handleException(m);
            m.printStackTrace();
        }
    }



    /*
    public static List<ReviewModel> getResponseByIdClubOwner(int idClubOwner) {

        List<ReviewModel> list = null;
        PreparedStatement preparedStatement = null;
        ReviewModel reviewModel = null;
        try {
            list = new ArrayList<>();
            preparedStatement = Query.searchReviewsByIdClubOwner(idClubOwner);
            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return list;
            }
            //rs.next();

            do {
                reviewModel = new ReviewModel();
                reviewModel.setIdReview(rs.getInt(1));
                reviewModel.setIdEvent(rs.getInt(4));
                reviewModel.setIdUser(rs.getInt(2));
                reviewModel.setComment(rs.getString(3));

                list.add(reviewModel);

            } while(rs.next());

            preparedStatement.close();
            return list;

        } catch ( SQLException e){
             ErrorHandler.getInstance().handleException(e);
            e.printStackTrace();
        }
        return list;
    }

     */

}
