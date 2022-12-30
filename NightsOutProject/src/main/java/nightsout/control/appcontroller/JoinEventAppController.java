package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.model.RequestModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.dao.RequestDAO;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class JoinEventAppController {

    private JoinEventAppController() {
        //ignored
    }
    public static List<ManageRequestBean> searchRequestsByIdClubOwner(int idClubOwner) throws SystemException {

        List<RequestModel> list = RequestDAO.getRequestsByIdClubOwner(idClubOwner);
        List<ManageRequestBean> listBean = new ArrayList<>();
        for(RequestModel rm : list){
            EventBean eb = new EventBean(EventDAO.getEventByIdEvent(rm.getIdEvent()));
            UserBean ub = new UserBean(UserDAO.getUserByidUser(rm.getIdUser()));
            ManageRequestBean bean = new ManageRequestBean(rm,ub,eb);
            listBean.add(bean);
        }
        return listBean;
    }
    public static void acceptRequest(int idRequest) throws SystemException {RequestDAO.updateRequestStatus(idRequest,"accepted");}
    public static void declineRequest(int idRequest) throws SystemException {RequestDAO.updateRequestStatus(idRequest,"declined");}
    public static UserBean searchUserByUsername(String username) throws SystemException {
        UserModel userModel = UserDAO.getUserByUsername(username);
        return new UserBean(userModel);
    }
    public static void sendRequest(UserBean userBean, EventBean eventBean) throws SystemException {
        UserModel userModel = new UserModel(userBean);
        EventModel eventModel = new EventModel(eventBean);
        RequestDAO.createRequest(userModel, eventModel);
    }
}
