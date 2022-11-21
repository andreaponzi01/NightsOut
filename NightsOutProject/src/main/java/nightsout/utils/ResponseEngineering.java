package nightsout.utils;

import nightsout.control.appcontroller.EventReviewsClubOwnerAppController;

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