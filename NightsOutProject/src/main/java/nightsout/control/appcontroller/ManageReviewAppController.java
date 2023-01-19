package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.model.ResponseModel;
import nightsout.model.ReviewModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.dao.ResponseDAO;
import nightsout.utils.dao.ReviewDAO;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.GenericBeanList;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.ReviewBeanList;

import java.util.ArrayList;
import java.util.List;

public class ManageReviewAppController {

    public void makeResponse(ResponseBean responseBean) throws SystemException {

        ResponseModel responseModel = new ResponseModel(responseBean);
        ResponseDAO responseDAO = new ResponseDAO();
        responseDAO.createResponse(responseModel);
    }
    public EventBean searchEventbyIdEvent(int idEvent) throws SystemException {

        EventDAO eventDAO = new EventDAO();
        return new EventBean(eventDAO.getEventByIdEvent(idEvent));    }

    public void createEventReview(ReviewBean reviewBean) throws SystemException {

        ReviewModel reviewModel = new ReviewModel(reviewBean);
        ReviewDAO reviewDAO = new ReviewDAO();
        reviewDAO.createEventReview(reviewModel);
    }

    public ReviewBean getReviewByIdEventAndIdUser(int idUser,int idEvent) throws SystemException {

        ReviewDAO reviewDAO = new ReviewDAO();
        ReviewModel reviewModel = reviewDAO.getReviewByIdEventAndIdUser(idEvent,idUser);
        if(reviewModel == null){
            return null;
        } else {
            return new ReviewBean(reviewModel);
        }
    }

    public void eventsToReview(Observer observer, int idUser) throws SystemException {

        GenericBeanList list = new GenericBeanList(observer);
        list.addEventsToList(searchEndedEventsByIdUser(idUser));
    }

    private List<EventBean> searchEndedEventsByIdUser(int idUser) throws SystemException {

        List<EventModel> list = null;
        List<EventBean> listBean = null;
        EventDAO eventDAO = new EventDAO();
        list = eventDAO.getEndedEventsByIdUser(idUser);
        listBean = new ArrayList<>();
        for(EventModel eventModel : list){
            EventBean bean = new EventBean(eventModel);
            listBean.add(bean);
        }
        return listBean;
    }

    public void eventReviews(Observer observer, int idClubOwner) throws SystemException {

        ReviewBeanList list = new ReviewBeanList(observer);
        list.addReviewToList(searchReviewsWithoutResponseByIdClubOwner(idClubOwner));
    }

    private List<ReviewBean> searchReviewsWithoutResponseByIdClubOwner(int idClubOwner) throws SystemException {
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

}
