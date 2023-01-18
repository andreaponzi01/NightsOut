package nightsout.utils.dao;

import nightsout.model.ReviewModel;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.SystemException;

import java.util.List;

public class ReviewDAO {

    Query query = new Query();

    public void createEventReview(ReviewModel reviewModel) throws SystemException {
        query.insertEventReview(reviewModel);
    }
    public List<ReviewModel> getReviewByIdClubOwner(int idClubOwner) throws SystemException {
        return query.searchReviewsByIdClubOwner(idClubOwner);
    }
    public List<ReviewModel> getAllReviewByIdClubOwner(int idClubOwner) throws SystemException {
        return query.searchAllReviewsByIdClubOwner(idClubOwner);
    }
    public ReviewModel getReviewByIdEventAndIdUser(int idEvent,int idUser) throws SystemException {
        return query.searchReviewByIdEventAndByIdUser( idUser, idEvent) ;
    }
}
