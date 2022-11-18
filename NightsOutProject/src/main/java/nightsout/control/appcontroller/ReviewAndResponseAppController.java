package nightsout.control.appcontroller;

import nightsout.model.ResponseModel;
import nightsout.model.ReviewModel;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.ResponseDAO;
import nightsout.utils.dao.ReviewDAO;
import nightsout.utils.dao.UserDAO;

import java.sql.SQLException;
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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBean;
    }
    /*
    public static List<ReviewBean> searchResponseByIdReviewProva(int idReview) {
        List<ReviewModel> list = null;
        List<ReviewBean> listBean = null;

        try {
           // list = ReviewDAO.getAllReviewByIdClubOwner(idReview);
            listBean = new ArrayList<>();

            for(ReviewModel reviewModel : list){
                ReviewBean bean = new ReviewBean(reviewModel);
                listBean.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBean;
    }
     */

    public static ResponseBean searchResponseByIdReview(int idReview) {
        ResponseModel responseModel = null;
        ResponseBean responseBean = null;

        try {

            responseModel = ResponseDAO.getResponseByIdReview(idReview);
            if(responseModel!=null){
                responseBean = new ResponseBean(responseModel);
                return responseBean;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseBean;
    }




}
