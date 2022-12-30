package nightsout.control.appcontroller;

import nightsout.model.ReviewModel;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.dao.ReviewDAO;
import nightsout.utils.exception.myexception.SystemException;

public class MakeReviewAppController {

    private MakeReviewAppController() {
        //ignored
    }
    public static void createEventReview(ReviewBean reviewBean) throws SystemException {

        ReviewModel reviewModel = new ReviewModel(reviewBean);
        ReviewDAO.createEventReview(reviewModel);
    }
}
