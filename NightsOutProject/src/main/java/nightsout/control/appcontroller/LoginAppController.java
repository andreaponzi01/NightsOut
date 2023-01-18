package nightsout.control.appcontroller;

import nightsout.model.ClubOwnerModel;
import nightsout.model.CredentialsModel;
import nightsout.model.UserModel;
import nightsout.utils.Session;
import nightsout.utils.bean.CredentialsBean;
import nightsout.utils.dao.ClubOwnerDAO;
import nightsout.utils.dao.LoginDAO;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.exception.myexception.WrongCredentialsException;

public class LoginAppController {

    Trigger trigger = new Trigger();

    public void login(CredentialsBean credentialsBean) throws WrongCredentialsException, SystemException {

        LoginDAO loginDAO = new LoginDAO();

        if(credentialsBean.getType().equalsIgnoreCase("Free")) {

            UserModel userModel = null;
            CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);
            if (loginDAO.checkIsRegistered(credentialsModel)) {
                UserDAO userDAO = new UserDAO();
                userModel = userDAO.getUserByUsername(credentialsBean.getUsername());
                Session.getInstance().setUser(userModel);
            } else {
                trigger.throwWrongCredentials();
                Session.getInstance().deleteSession();
            }

        } else {

            ClubOwnerModel clubOwnerModel = null;
            CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);
            if (loginDAO.checkIsRegistered(credentialsModel)) {
                ClubOwnerDAO clubOwnerDAO = new ClubOwnerDAO();
                clubOwnerModel = clubOwnerDAO.getClubOwnerByUsername(credentialsBean.getUsername());
                Session.getInstance().setClubOwner(clubOwnerModel);

            } else {
                trigger.throwWrongCredentials();
                Session.getInstance().deleteSession();
            }
        }
    }
}
