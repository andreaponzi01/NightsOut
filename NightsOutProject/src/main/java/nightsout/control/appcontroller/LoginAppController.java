package nightsout.control.appcontroller;

import nightsout.model.ClubOwnerModel;
import nightsout.model.CredentialsModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.CredentialsBean;
import nightsout.utils.bean.LoggedBean;
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
    public static void login(CredentialsBean credentialsBean) throws WrongCredentialsException, SystemException {

        if(credentialsBean.getType().equalsIgnoreCase("Free")) {

            UserModel userModel = null;
            CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);
            if (LoginDAO.checkIsRegistered(credentialsModel)) {
                userModel = UserDAO.getUserByUsername(credentialsBean.getUsername());
                LoggedBean.getInstance().setUser(userModel);
            } else {
                Trigger.throwWrongCredentials();
                LoggedBean.getInstance().deleteSession();
            }

        } else {

            ClubOwnerModel clubOwnerModel = null;
            CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);
            if (LoginDAO.checkIsRegistered(credentialsModel)) {
                clubOwnerModel = ClubOwnerDAO.getClubOwnerByUsername(credentialsBean.getUsername());
                LoggedBean.getInstance().setClubOwner(clubOwnerModel);

            } else {
                Trigger.throwWrongCredentials();
                LoggedBean.getInstance().deleteSession();
            }
        }
    }
}
