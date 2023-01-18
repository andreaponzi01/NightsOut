package nightsout.utils.engineering;

import nightsout.control.appcontroller.ManageReviewAppController;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.ReviewBeanList;

public class CommunityEngineering {

    public void responseOfOneReview(Observer observer, int idReview) throws SystemException {

        ManageReviewAppController controller = new ManageReviewAppController();
        ResponseBean response = new ResponseBean(observer);
        response.addResponse(controller.searchResponseByIdReview(idReview));
    }

    public void eventReviews(Observer observer, int idClubOwner) throws SystemException {

        ManageReviewAppController controller = new ManageReviewAppController();
        ReviewBeanList list = new ReviewBeanList(observer);
        list.addReviewToList(controller.searchReviewsByIdClubOwner(idClubOwner));
    }

}
