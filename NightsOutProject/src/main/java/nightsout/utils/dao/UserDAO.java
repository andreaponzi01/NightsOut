package nightsout.utils.dao;

import nightsout.model.CredentialsModel;
import nightsout.model.UserModel;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.SystemException;

import java.util.List;

public class UserDAO {

    private UserDAO() {
        //ignored
    }
    public static UserModel getUserByUsername(String username) throws SystemException {
        return Query.searchUserByUsername(username);
    }
    public static void insertUser(CredentialsModel credentialsModel, UserModel userModel) throws SystemException {
        Query.insertCredentials(credentialsModel);
        Query.insertUser(userModel);
    }
    public static UserModel subscriptionVip(UserModel userModel) throws SystemException {
        Query.subscriptionVipUser(userModel.getUsername());
        return Query.searchUserByUsername(userModel.getUsername());
    }
    public static List<UserModel> getUsersByUsername(String username) throws SystemException {
        return Query.searchUsersByUsername(username);
    }
    public static List<UserModel> getUsersByIdEvent(int idEvent) throws SystemException {
        return Query.searchUsersByIdEvent(idEvent);
    }
    public static UserModel getUserByidUser(int idUser) throws SystemException {
        return Query.searchUsersByIdUser(idUser);
    }
    public static boolean checkUsername(String username) throws SystemException {
        return Query.checkUsernameAlreadyTaken(username);
    }
}
