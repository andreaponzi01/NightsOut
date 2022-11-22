package nightsout.control.appcontroller;

import nightsout.model.ClubOwnerModel;
import nightsout.model.UserModel;
import nightsout.utils.Authentication;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.LoginBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.ClubOwnerDAO;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.WrongCredentialsException;

public class LoginAppController {

    private LoginAppController() {
        //ignored
    }

    public static UserBean loginUser(LoginBean loginBean) throws WrongCredentialsException {

            UserModel userModel = null;
            UserBean userBean = null;

            if (Authentication.checkIsRegistered(loginBean.getUsername(), loginBean.getPassword(), loginBean.getType())) {
                userModel = UserDAO.getUserByUsername(loginBean.getUsername());
                userBean = new UserBean(userModel);
                userBean.setType("Free");
            } else {
                Trigger.throwWrongPassword();
            }

            return userBean;
    }

    public static ClubOwnerBean loginClubOwner(LoginBean loginBean) throws WrongCredentialsException {

            ClubOwnerModel clubOwnerModel = null;
            ClubOwnerBean clubOwnerBean = null;

            if (Authentication.checkIsRegistered(loginBean.getUsername(), loginBean.getPassword(), loginBean.getType())) {
                clubOwnerModel = ClubOwnerDAO.getClubOwnerByUsername(loginBean.getUsername());
                clubOwnerBean = new ClubOwnerBean(clubOwnerModel);
                clubOwnerBean.setType("Club Owner");
            } else {
                Trigger.throwWrongPassword();
            }

            return clubOwnerBean;
    }
}
