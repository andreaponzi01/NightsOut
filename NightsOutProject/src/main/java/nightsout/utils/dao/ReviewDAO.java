package nightsout.utils.dao;

import nightsout.model.ReviewModel;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.SystemException;

import java.util.List;

public class ReviewDAO {

    private ReviewDAO() {
        //ignore
    }

    public static void createEventReview(ReviewModel reviewModel) throws SystemException {
        Query.insertEventReview(reviewModel);
    }


    public static List<ReviewModel> getReviewByIdClubOwner(int idClubOwner) throws SystemException {
        return Query.searchReviewsByIdClubOwner(idClubOwner);
    }

    public static List<ReviewModel> getAllReviewByIdClubOwner(int idClubOwner) throws SystemException {
        return Query.searchAllReviewsByIdClubOwner(idClubOwner);
    }

    public static ReviewModel getReviewByIdEventAndIdUser(int idEvent,int idUser) throws SystemException {
        return Query.searchReviewByIdEventAndByIdUser( idUser, idEvent) ;
    }
}
