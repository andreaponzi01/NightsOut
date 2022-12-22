package nightsout.control.appcontroller;

import nightsout.model.ClubOwnerModel;
import nightsout.model.CredentialsModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.CredentialsBean;
import nightsout.utils.bean.LoggedClubOwnerBean1;
import nightsout.utils.bean.LoggedClubOwnerBean2;
import nightsout.utils.bean.LoggedUserBean1;
import nightsout.utils.dao.ClubOwnerDAO;
import nightsout.utils.dao.LoginDAO;
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
            LoggedUserBean1.getInstance(userModel);
        } else {
            Trigger.throwWrongCredentials();
            LoggedUserBean1.deleteInstance();
        }
    }

    public static void loginClubOwner1(CredentialsBean credentialsBean) throws SystemException, WrongCredentialsException {

        ClubOwnerModel clubOwnerModel = null;

        CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);
        if (LoginDAO.checkIsRegistered(credentialsModel)) {
            clubOwnerModel = ClubOwnerDAO.getClubOwnerByUsername(credentialsBean.getUsername());
            LoggedClubOwnerBean1.getInstance(clubOwnerModel);
        } else {
            Trigger.throwWrongCredentials();
            LoggedClubOwnerBean1.deleteInstance();
        }
    }

    public static void loginClubOwner2(CredentialsBean credentialsBean) throws SystemException, WrongCredentialsException {

        ClubOwnerModel clubOwnerModel = null;

        CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);
        if (LoginDAO.checkIsRegistered(credentialsModel)) {
            clubOwnerModel = ClubOwnerDAO.getClubOwnerByUsername(credentialsBean.getUsername());
            LoggedClubOwnerBean2.getInstance(clubOwnerModel);
        } else {
            Trigger.throwWrongCredentials();
            LoggedClubOwnerBean1.deleteInstance();
        }
    }
}
