package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.model.ReviewModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.dao.ReviewDAO;
import nightsout.utils.dao.UserDAO;

import java.sql.SQLException;
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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBean;
    }

    public static UserBean searchUserbyIdUser(int idUser) throws SQLException {
        UserBean userBean= new UserBean(UserDAO.getUserByidUser(idUser));
        return userBean;
    }


}
