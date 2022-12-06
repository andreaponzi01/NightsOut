package nightsout.control.appcontroller;

import nightsout.control.guicontroller.MyNotification;
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

    public static List<ReviewBean> searchReviewsByIdClubOwner(int idClubOwner) {
        List<ReviewModel> list = null;
        List<ReviewBean> listBean = null;

        try {
            list = ReviewDAO.getReviewByIdClubOwner(idClubOwner);
            listBean = new ArrayList<>();

            for(ReviewModel reviewModel : list){
                ReviewBean bean = new ReviewBean(reviewModel);
                listBean.add(bean);
            }

        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
        return listBean;
    }

    public static UserBean searchUserbyIdUser(int idUser) throws SystemException {
        UserBean userBean= new UserBean(UserDAO.getUserByidUser(idUser));
        return userBean;
    }


    public static EventBean searchEventbyIdEvent(int idEvent) throws SystemException{
        EventBean eventBean= new EventBean(EventDAO.getEventByIdEvent(idEvent));
        return eventBean;
    }
}
