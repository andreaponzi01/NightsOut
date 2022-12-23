package nightsout.control.appcontroller;

import nightsout.model.ReviewModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.dao.ReviewDAO;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class EventReviewsClubOwnerAppController {

    private EventReviewsClubOwnerAppController(){
        //ignore
    }

    public static List<ReviewBean> searchReviewsByIdClubOwner(int idClubOwner) throws SystemException {
        List<ReviewModel> list = null;
        List<ReviewBean> listBean = null;

        list = ReviewDAO.getReviewByIdClubOwner(idClubOwner);
        listBean = new ArrayList<>();

        for(ReviewModel reviewModel : list){
            ReviewBean bean = new ReviewBean(reviewModel);
            listBean.add(bean);
        }

        return listBean;
    }

    public static UserBean searchUserbyIdUser(int idUser) throws SystemException {
        return new UserBean(UserDAO.getUserByidUser(idUser));
    }


    public static EventBean searchEventbyIdEvent(int idEvent) throws SystemException {
        return new EventBean(EventDAO.getEventByIdEvent(idEvent));
    }
}
