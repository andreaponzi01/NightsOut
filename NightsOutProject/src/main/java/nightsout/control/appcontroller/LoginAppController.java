package nightsout.control.appcontroller;

import nightsout.model.ClubOwnerModel;
import nightsout.model.CredentialsModel;
import nightsout.model.UserModel;
import nightsout.utils.dao.LoginDAO;
import nightsout.utils.bean.LoggedClubOwnerBean;
import nightsout.utils.bean.LoggedUserBean;
import nightsout.utils.bean.CredentialsBean;
import nightsout.utils.dao.ClubOwnerDAO;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.exception.myexception.WrongCredentialsException;

public class LoginAppController {

    private LoginAppController() {
        //ignored
    }

    public static void loginUser(CredentialsBean credentialsBean) throws WrongCredentialsException, SystemException {

        UserModel userModel = null;

        CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);
        if (LoginDAO.checkIsRegistered(credentialsModel)) {
            userModel = UserDAO.getUserByUsername(credentialsBean.getUsername());
            LoggedUserBean.getInstance(userModel);
        } else {
            Trigger.throwWrongCredentials();
            LoggedUserBean.deleteInstance();
        }
    }

    public static void loginClubOwner(CredentialsBean credentialsBean) throws SystemException, WrongCredentialsException {

        ClubOwnerModel clubOwnerModel = null;

        CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);
        if (LoginDAO.checkIsRegistered(credentialsModel)) {
            clubOwnerModel = ClubOwnerDAO.getClubOwnerByUsername(credentialsBean.getUsername());
            LoggedClubOwnerBean.getInstance(clubOwnerModel);
        } else {
            Trigger.throwWrongCredentials();
            LoggedClubOwnerBean.deleteInstance();
        }
    }
}
