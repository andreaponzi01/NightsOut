package nightsout.control.appcontroller;

import nightsout.model.ReviewModel;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.dao.ReviewDAO;

public class CreateEventReviewAppController {

    private CreateEventReviewAppController() {
        //ignored
    }

    public static void createEventReview(ReviewBean reviewBean) {
        ReviewModel reviewModel = new ReviewModel(reviewBean);
        ReviewDAO.createEventReview(reviewModel);
    }

}
