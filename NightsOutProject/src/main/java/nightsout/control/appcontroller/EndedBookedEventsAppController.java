package nightsout.control.appcontroller;

import nightsout.model.ClubOwnerModel;
import nightsout.model.ReviewModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.ClubOwnerDAO;
import nightsout.utils.dao.ReviewDAO;
import nightsout.utils.dao.UserDAO;

import java.util.ArrayList;
import java.util.List;

public class EndedBookedEventsAppController {

    private EndedBookedEventsAppController() {
        //ignored
    }


    public static ReviewBean getReviewByIdEventAndIdUser(int idUser,int idEvent) {
        ReviewModel reviewModel = ReviewDAO.getReviewByIdEventAndIdUser(idEvent,idUser);
        if(reviewModel==null){
            return null;
        }else{
            ReviewBean reviewBean= new ReviewBean(reviewModel);
            return reviewBean;
        }

    }



}
