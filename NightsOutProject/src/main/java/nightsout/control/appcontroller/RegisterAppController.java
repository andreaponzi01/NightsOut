package nightsout.control.appcontroller;

import nightsout.model.ClubOwnerModel;
import nightsout.model.CredentialsModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.CredentialsBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.ClubOwnerDAO;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.SystemException;

public class RegisterAppController {

    public void registerClubOwner(ClubOwnerBean clubOwnerBean, CredentialsBean credentialsBean) throws SystemException {

        CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);
        ClubOwnerModel clubOwnerModel = new ClubOwnerModel(clubOwnerBean);
        ClubOwnerDAO clubOwnerDAO = new ClubOwnerDAO();
        clubOwnerDAO.insertClubOwner(credentialsModel, clubOwnerModel);
    }
    public void registerUser(UserBean userBean, CredentialsBean credentialsBean) throws SystemException {

        CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);
        UserModel userModel = new UserModel(userBean);
        UserDAO userDAO = new UserDAO();
        userDAO.insertUser(credentialsModel, userModel);
    }
    public boolean usernameAlreadyTaken(String username) throws SystemException {
        UserDAO userDAO = new UserDAO();
        return userDAO.checkUsername(username);}
}
