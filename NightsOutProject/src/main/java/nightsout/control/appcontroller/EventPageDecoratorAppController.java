package nightsout.control.appcontroller;

import nightsout.model.ClubOwnerModel;
import nightsout.model.EventModel;
import nightsout.model.RequestModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.ClubOwnerDAO;
import nightsout.utils.dao.RequestDAO;
import nightsout.utils.dao.UserDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventPageDecoratorAppController {

    private EventPageDecoratorAppController() {
        //ignored
    }

    public static RequestBean checkRequestStatus(UserBean userBean, EventBean eventBean) {
        UserModel userModel = new UserModel(userBean);
        EventModel eventModel = new EventModel(eventBean);
        RequestModel requestModel = RequestDAO.checkRequestStatus(userModel, eventModel);
        if(requestModel==null)
            return null;
        return (new RequestBean(requestModel));
    }

    public static UserBean searchUsersByUsername(String username) throws SQLException {
        UserModel userModel = UserDAO.getUserByUsername(username);
        return new UserBean(userModel);
    }

    public static ClubOwnerBean searchClubOwnerByUsername(String username) throws SQLException {
        ClubOwnerModel clubOwnerModel = ClubOwnerDAO.getClubOwnerByUsername(username);
        return new ClubOwnerBean(clubOwnerModel);
    }


    public static ClubOwnerBean getClubOwner(int idClubOwner) {
        ClubOwnerModel clubOwnerModel = ClubOwnerDAO.getClubOwnerById(idClubOwner);
        ClubOwnerBean clubOwnerBean= new ClubOwnerBean(clubOwnerModel);
        return clubOwnerBean;
    }

    public static List<UserBean> searchUsersByIdEvent(int idEvent) {
        List<UserModel> list = null;
        List<UserBean> listBean = null;
        try {
            list = UserDAO.getUsersByIdEvent(idEvent);
            listBean = new ArrayList<>();

            for(UserModel um : list){
                UserBean bean = new UserBean(um);
                listBean.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBean;
    }


}
