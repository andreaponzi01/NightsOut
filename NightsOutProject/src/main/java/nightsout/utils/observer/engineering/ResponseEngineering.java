package nightsout.utils.observer.engineering;

import nightsout.control.appcontroller.EventReviewsClubOwnerAppController;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.ReviewBeanList;

import java.sql.SQLException;

public class ResponseEngineering {

    private ResponseEngineering() {
        //ignored
    }

    public static void eventReviews(Observer observer, int idClubOwner) throws SQLException {
        ReviewBeanList list = new ReviewBeanList(observer);
        list.addReviewToList(EventReviewsClubOwnerAppController.searchReviewsByIdClubOwner(idClubOwner));
    }
}
