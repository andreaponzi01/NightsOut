package nightsout.control.appcontroller;

import nightsout.model.ClubOwnerModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.Credentials;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.ClubOwnerDAO;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.SystemException;

public class RegisterAppController {

    private RegisterAppController() {
        //ignored
    }

    public static void registerClubOwner(ClubOwnerBean clubOwnerBean) throws SystemException {
        Credentials myCred = new Credentials(clubOwnerBean.getUsername(), clubOwnerBean.getPassword(), "ClubOwner");
        ClubOwnerModel clubOwnerModel = new ClubOwnerModel(clubOwnerBean, myCred);
        ClubOwnerDAO.insertClubOwner(clubOwnerModel);
    }

    public static void registerUser(UserBean userBean) throws SystemException {
        Credentials myCred = new Credentials(userBean.getUsername(), userBean.getPassword(), "Free");
        UserModel userModel = new UserModel(userBean, myCred);
        UserDAO.insertUser(userModel);
    }

}
