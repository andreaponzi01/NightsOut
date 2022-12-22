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

    private RegisterAppController() {
        //ignored
    }

    public static void registerClubOwner(ClubOwnerBean clubOwnerBean, CredentialsBean credentialsBean) throws SystemException {

        CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);
        ClubOwnerModel clubOwnerModel = new ClubOwnerModel(clubOwnerBean);
        ClubOwnerDAO.insertClubOwner(credentialsModel, clubOwnerModel);
    }

    public static void registerUser(UserBean userBean, CredentialsBean credentialsBean) throws SystemException {

        CredentialsModel credentialsModel = new CredentialsModel(credentialsBean);
        UserModel userModel = new UserModel(userBean);
        UserDAO.insertUser(credentialsModel, userModel);
    }

    public static boolean usernameAlreadyTaken(String username) throws SystemException {

        return UserDAO.checkUsername(username);
    }
}
