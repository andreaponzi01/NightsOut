package nightsout.utils.observer.engineering;

import nightsout.control.appcontroller.EventReviewsClubOwnerAppController;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.ReviewBeanList;

public class ResponseEngineering {

    private ResponseEngineering() {
        //ignored
    }

    public static void eventReviews(Observer observer, int idClubOwner) throws SystemException {

        ReviewBeanList list = new ReviewBeanList(observer);
        list.addReviewToList(EventReviewsClubOwnerAppController.searchReviewsByIdClubOwner(idClubOwner));
    }
}
