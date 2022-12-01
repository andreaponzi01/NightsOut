package nightsout.control.appcontroller;

import nightsout.control.guicontroller.MyNotification;
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

    public static List<ReviewBean> searchReviewsByIdClubOwner(int idClubOwner) {
        List<ReviewModel> list = null;
        List<ReviewBean> listBean = null;

        try {
            list = ReviewDAO.getAllReviewByIdClubOwner(idClubOwner);
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

    public static ResponseBean searchResponseByIdReview(int idReview) {
        ResponseModel responseModel = null;
        ResponseBean responseBean = null;

        try {

            responseModel = ResponseDAO.getResponseByIdReview(idReview);
            if(responseModel!=null){
                responseBean = new ResponseBean(responseModel);
                return responseBean;
            }


        } catch (SystemException e) {
           MyNotification.createNotification(e);
        }
        return responseBean;
    }




}
