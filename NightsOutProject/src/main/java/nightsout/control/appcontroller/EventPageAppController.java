package nightsout.control.appcontroller;

import nightsout.model.ClubOwnerModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.dao.ClubOwnerDAO;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class EventPageAppController {

    public String getClubAddress(int idEvent) throws SystemException {

        ClubOwnerDAO clubOwnerDAO = new ClubOwnerDAO();
        ClubOwnerModel clubOwnerModel = clubOwnerDAO.getClubAddressByIdEvent(idEvent);
        return (clubOwnerModel.getAddress() + ", " + clubOwnerModel.getCity());
    }

    public ClubOwnerBean getClubOwner(int idClubOwner) throws SystemException {

        ClubOwnerDAO clubOwnerDAO = new ClubOwnerDAO();
        ClubOwnerModel clubOwnerModel = clubOwnerDAO.getClubOwnerById(idClubOwner);
        return new ClubOwnerBean1(clubOwnerModel);
    }
    public List<UserBean> searchUsersByIdEvent(int idEvent) throws SystemException {

        UserDAO userDAO = new UserDAO();
        List<UserModel> list = userDAO.getUsersByIdEvent(idEvent);
        List<UserBean> listBean = new ArrayList<>();
        for(UserModel um : list){
            UserBean bean = new UserBean(um);
            listBean.add(bean);
        }
        return listBean;
    }

}
