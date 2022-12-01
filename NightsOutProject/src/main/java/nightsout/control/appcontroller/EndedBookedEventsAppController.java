package nightsout.control.appcontroller;

import nightsout.model.ReviewModel;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.dao.ReviewDAO;
import nightsout.utils.exception.myexception.SystemException;

public class EndedBookedEventsAppController {

    private EndedBookedEventsAppController() {
        //ignored
    }


    public static ReviewBean getReviewByIdEventAndIdUser(int idUser,int idEvent) throws SystemException {
        ReviewModel reviewModel = ReviewDAO.getReviewByIdEventAndIdUser(idEvent,idUser);
        if(reviewModel==null){
            return null;
        }else{
            ReviewBean reviewBean= new ReviewBean(reviewModel);
            return reviewBean;
        }

    }



}
