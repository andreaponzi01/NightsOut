package nightsout.control.appcontroller;

import nightsout.model.ClubOwnerModel;
import nightsout.model.UserModel;
import nightsout.utils.Authentication;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.LoggedClubOwnerBean;
import nightsout.utils.bean.LoggedUserBean;
import nightsout.utils.bean.LoginBean;
import nightsout.utils.dao.ClubOwnerDAO;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.WrongCredentialsException;

public class LoginAppController {

    private LoginAppController() {
        //ignored
    }

    /*
    public static UserBean loginUser(LoginBean loginBean) throws WrongCredentialsException {

            UserModel userModel = null;
            UserBean userBean = null;

            if (Authentication.checkIsRegistered(loginBean.getUsername(), loginBean.getPassword(), loginBean.getType())) {
                userModel = UserDAO.getUserByUsername(loginBean.getUsername());
                userBean = new UserBean(userModel);
                userBean.setType("Free");
            } else {
                Trigger.throwWrongCredentials();
            }

            return userBean;
    }
    */

    public static void loginUser(LoginBean loginBean) throws WrongCredentialsException {

        UserModel userModel = null;
        LoggedUserBean loggedUserBean = null;

        if (Authentication.checkIsRegistered(loginBean.getUsername(), loginBean.getPassword(), loginBean.getType())) {
            userModel = UserDAO.getUserByUsername(loginBean.getUsername());
            loggedUserBean = LoggedUserBean.getInstance(userModel);
        } else {
            Trigger.throwWrongCredentials();
        }
    }

    public static void loginClubOwner(LoginBean loginBean) throws WrongCredentialsException {

        ClubOwnerModel clubOwnerModel = null;
        LoggedClubOwnerBean loggedClubOwnerBean=null;

        if (Authentication.checkIsRegistered(loginBean.getUsername(), loginBean.getPassword(), loginBean.getType())) {
            clubOwnerModel = ClubOwnerDAO.getClubOwnerByUsername(loginBean.getUsername());
            loggedClubOwnerBean = LoggedClubOwnerBean.getInstance(clubOwnerModel);
        } else {
            Trigger.throwWrongCredentials();
        }
    }
}
