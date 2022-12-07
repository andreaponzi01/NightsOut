package nightsout.control.appcontroller;

import nightsout.model.ResponseModel;
import nightsout.model.ReviewModel;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.dao.ResponseDAO;
import nightsout.utils.dao.ReviewDAO;
import nightsout.utils.exception.myexception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class ReviewAndResponseAppController {
    private ReviewAndResponseAppController(){
        //ignore
    }

    public static List<ReviewBean> searchReviewsByIdClubOwner(int idClubOwner) throws SystemException {
        List<ReviewModel> list = null;
        List<ReviewBean> listBean = null;
        list = ReviewDAO.getAllReviewByIdClubOwner(idClubOwner);
        listBean = new ArrayList<>();

        for(ReviewModel reviewModel : list){
            ReviewBean bean = new ReviewBean(reviewModel);
            listBean.add(bean);
        }
        return listBean;
    }

    public static ResponseBean searchResponseByIdReview(int idReview) throws SystemException {
        ResponseModel responseModel = null;
        ResponseBean responseBean = null;
        responseModel = ResponseDAO.getResponseByIdReview(idReview);
        if(responseModel!=null) {
            responseBean = new ResponseBean(responseModel);
            return responseBean;
        }
        return responseBean;
    }




}
