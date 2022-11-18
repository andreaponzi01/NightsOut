package nightsout.utils;

import nightsout.control.appcontroller.EventReviewsClubOwnerAppController;
import nightsout.control.appcontroller.ReviewAndResponseAppController;
import nightsout.control.appcontroller.UserPageAppController;
import nightsout.control.guicontroller.interface1.ReviewAndResponseGUIController1;

import java.sql.SQLException;

public class ReviewAndResponseEngineering {

    private ReviewAndResponseEngineering() {
        //ignored
    }

    public static void ResponseOfOneReview(Observer observer, int idReview) throws SQLException {
        ResponseBeanList list = new ResponseBeanList(observer);
        list.addResponseToList(ReviewAndResponseAppController.searchResponseByIdReview(idReview));
    }

    public static void eventReviews(Observer observer, int idClubOwner) throws SQLException {
        ReviewBeanList list = new ReviewBeanList(observer);
        list.addReviewToList(ReviewAndResponseAppController.searchReviewsByIdClubOwner(idClubOwner));
    }

}
