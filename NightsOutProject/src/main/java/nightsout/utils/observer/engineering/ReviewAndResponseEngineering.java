package nightsout.utils.observer.engineering;

import nightsout.control.appcontroller.ReviewAndResponseAppController;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.ReviewBeanList;

import java.sql.SQLException;

public class ReviewAndResponseEngineering {

    private ReviewAndResponseEngineering() {
        //ignored
    }

    public static void ResponseOfOneReview(Observer observer, int idReview) throws SQLException {
        ResponseBean response = new ResponseBean(observer);
        response.addResponse(ReviewAndResponseAppController.searchResponseByIdReview(idReview));
    }

    public static void eventReviews(Observer observer, int idClubOwner) throws SQLException {
        ReviewBeanList list = new ReviewBeanList(observer);
        list.addReviewToList(ReviewAndResponseAppController.searchReviewsByIdClubOwner(idClubOwner));
    }

}
