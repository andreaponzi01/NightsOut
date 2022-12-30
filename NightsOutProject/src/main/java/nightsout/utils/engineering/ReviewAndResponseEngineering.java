package nightsout.utils.engineering;

import nightsout.control.appcontroller.ResponsePageAppController;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.ReviewBeanList;

public class ReviewAndResponseEngineering {

    private ReviewAndResponseEngineering() {
        //ignored
    }

    public static void responseOfOneReview(Observer observer, int idReview) throws SystemException {
        ResponseBean response = new ResponseBean(observer);
        response.addResponse(ResponsePageAppController.searchResponseByIdReview(idReview));
    }

    public static void eventReviews(Observer observer, int idClubOwner) throws SystemException {

        ReviewBeanList list = new ReviewBeanList(observer);
        list.addReviewToList(ResponsePageAppController.searchReviewsByIdClubOwner(idClubOwner));
    }

}
