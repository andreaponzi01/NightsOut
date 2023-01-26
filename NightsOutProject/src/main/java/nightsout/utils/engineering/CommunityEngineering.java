package nightsout.utils.engineering;

import nightsout.model.ResponseModel;
import nightsout.model.ReviewModel;
import nightsout.utils.bean.IdBean;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.dao.ResponseDAO;
import nightsout.utils.dao.ReviewDAO;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.ReviewBeanList;

import java.util.ArrayList;
import java.util.List;

public class CommunityEngineering {

    public void responseOfOneReview(Observer observer, IdBean idBean) throws SystemException {

        ResponseBean response = new ResponseBean(observer);
        response.addResponse(searchResponseByIdReview(idBean.getId()));
    }

    public void eventReviews(Observer observer, IdBean idBean) throws SystemException {

        ReviewBeanList list = new ReviewBeanList(observer);
        list.addReviewToList(searchReviewsByIdClubOwner(idBean.getId()));
    }

    private List<ReviewBean> searchReviewsByIdClubOwner(int idClubOwner) throws SystemException {

        List<ReviewModel> list = null;
        List<ReviewBean> listBean = null;
        ReviewDAO reviewDAO = new ReviewDAO();
        list = reviewDAO.getAllReviewByIdClubOwner(idClubOwner);
        listBean = new ArrayList<>();
        for(ReviewModel reviewModel : list){
            ReviewBean bean = new ReviewBean(reviewModel);
            listBean.add(bean);
        }
        return listBean;
    }

    private ResponseBean searchResponseByIdReview(int idReview) throws SystemException {

        ResponseModel responseModel = null;
        ResponseBean responseBean = null;
        ResponseDAO responseDAO = new ResponseDAO();
        responseModel = responseDAO.getResponseByIdReview(idReview);
        if(responseModel!=null) {
            responseBean = new ResponseBean(responseModel);
            return responseBean;
        }
        return responseBean;
    }

}
