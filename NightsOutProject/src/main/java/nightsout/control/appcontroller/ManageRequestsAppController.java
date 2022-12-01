package nightsout.control.appcontroller;

import nightsout.control.guicontroller.MyNotification;
import nightsout.model.ManageRequestModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.RequestDAO;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.DBConnectionFailedException;
import nightsout.utils.exception.myexception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class ManageRequestsAppController {

    private ManageRequestsAppController() {
        //ignored
    }
    public static List<ManageRequestBean> searchRequestsByIdClubOwner(int idClubOwner) {
        List<ManageRequestModel> list = null;
        List<ManageRequestBean> listBean = null;
        try {
            list = RequestDAO.getRequestsByIdClubOwner(idClubOwner);
            listBean = new ArrayList<>();

            for(ManageRequestModel mrm : list){
                ManageRequestBean bean = new ManageRequestBean(mrm);
                listBean.add(bean);
            }

        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
        return listBean;
    }

    public static void acceptRequest(int idRequest) throws SystemException {
        RequestDAO.UpdateRequestStatus(idRequest,"accepted");
    }

    public static void declineRequest(int idRequest) throws SystemException {
        RequestDAO.UpdateRequestStatus(idRequest,"declined");
    }

    public static UserBean searchUserByUsername(String username) throws SystemException {
        UserBean userBean = null;
        try {
            UserModel userModel = UserDAO.getUserByUsername(username);
            userBean = new UserBean(userModel);
        } catch (DBConnectionFailedException e) {
            MyNotification.createNotification(e);
        }
        return  userBean;
    }

}
