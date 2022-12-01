package nightsout.control.appcontroller;

import nightsout.control.guicontroller.MyNotification;
import nightsout.model.ClubOwnerModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.ClubOwnerDAO;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class EventPageAppController {

    private EventPageAppController() {
        //ignored
    }

    public static String getClubAddress(int idEvent) throws SystemException {
        ClubOwnerModel clubOwnerModel = ClubOwnerDAO.getClubAddressByIdEvent(idEvent);
        return (clubOwnerModel.getAddress() + ", " + clubOwnerModel.getCity());
    }


    public static ClubOwnerBean getClubOwner(int idClubOwner) throws SystemException {
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

        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
        return listBean;
    }

}
