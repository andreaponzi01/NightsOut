package nightsout.control.appcontroller;

import nightsout.model.ManageRequestModel;
import nightsout.model.RequestModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.RequestDAO;
import nightsout.utils.dao.UserDAO;

import java.sql.SQLException;
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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBean;
    }

    public static void acceptRequest(int idRequest) throws SQLException {
        RequestDAO.UpdateRequestStatus(idRequest,"accepted");
    }

    public static void declineRequest(int idRequest) throws SQLException {
        RequestDAO.UpdateRequestStatus(idRequest,"declined");
    }

    public static UserBean searchUserByUsername(String username) throws SQLException {
        UserModel userModel= UserDAO.getUserByUsername(username);
        UserBean userBean = new UserBean(userModel);
        return  userBean;
    }

}
