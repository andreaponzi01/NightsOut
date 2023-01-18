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
    public List<ReviewBean> searchReviewsByIdClubOwner(int idClubOwner) throws SystemException {
        List<ReviewModel> list = null;
        List<ReviewBean> listBean = null;
        ReviewDAO reviewDAO = new ReviewDAO();
        list = reviewDAO.getReviewByIdClubOwner(idClubOwner);
        listBean = new ArrayList<>();
        for(ReviewModel reviewModel : list){
            ReviewBean bean = new ReviewBean(reviewModel);
            listBean.add(bean);
        }
        return listBean;
    }
    public UserBean searchUserbyIdUser(int idUser) throws SystemException {
        UserDAO userDAO = new UserDAO();
        return new UserBean(userDAO.getUserByidUser(idUser));}
    public EventBean searchEventbyIdEvent(int idEvent) throws SystemException {
        EventDAO eventDAO = new EventDAO();
        return new EventBean(eventDAO.getEventByIdEvent(idEvent));}
}
