package nightsout.utils.dao;

import nightsout.model.ReviewModel;
import nightsout.utils.db.Query;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {

    public ReviewDAO() {
        //ignore
    }

    public static void createEventReview(ReviewModel reviewModel) throws SystemException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = Query.insertEventReview(reviewModel);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException /*| FileNotFoundException*/ m) {
            ExceptionHandler.handleException(m);
        }
    }


    public static List<ReviewModel> getReviewByIdClubOwner(int idClubOwner) throws SystemException {

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

        } catch (SQLException e){
           ExceptionHandler.handleException(e);
        }
        return list;
    }

    public static List<ReviewModel> getAllReviewByIdClubOwner(int idClubOwner) throws SystemException {

        List<ReviewModel> list = null;
        PreparedStatement preparedStatement = null;
        ReviewModel reviewModel = null;
        try {
            list = new ArrayList<>();
            preparedStatement = Query.searchAllReviewsByIdClubOwner(idClubOwner);
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

        } catch (SQLException e){
            ExceptionHandler.handleException(e);
        }
        return list;
    }

    public static ReviewModel getReviewByIdEventAndIdUser(int idEvent,int idUser) throws SystemException {

        PreparedStatement preparedStatement = null;
        ReviewModel reviewModel = null;
        try {

            preparedStatement = Query.searchReviewByIdEventAndByIdUser( idUser, idEvent) ;
            ResultSet rs = preparedStatement.executeQuery();
            assert rs != null;
            if (!rs.next()) {
                return null;
            }
            //rs.next();

            reviewModel = new ReviewModel();
            reviewModel.setIdReview(rs.getInt(1));
            reviewModel.setIdEvent(rs.getInt(4));
            reviewModel.setIdUser(rs.getInt(2));
            reviewModel.setComment(rs.getString(3));


            preparedStatement.close();
            return reviewModel;

        } catch (SQLException e){
            ExceptionHandler.handleException(e);
        }
        return reviewModel;
    }
}
