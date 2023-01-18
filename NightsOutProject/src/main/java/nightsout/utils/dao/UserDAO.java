package nightsout.utils.dao;

import nightsout.model.CredentialsModel;
import nightsout.model.UserModel;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.SystemException;

import java.util.List;

public class UserDAO {

    Query query = new Query();
    public UserModel getUserByUsername(String username) throws SystemException {
        return query.searchUserByUsername(username);
    }
    public void insertUser(CredentialsModel credentialsModel, UserModel userModel) throws SystemException {
        query.insertCredentials(credentialsModel);
        query.insertUser(userModel);
    }
    public UserModel subscriptionVip(UserModel userModel) throws SystemException {
        query.subscriptionVipUser(userModel.getUsername());
        return query.searchUserByUsername(userModel.getUsername());
    }
    public List<UserModel> getUsersByUsername(String username) throws SystemException {
        return query.searchUsersByUsername(username);
    }
    public List<UserModel> getUsersByIdEvent(int idEvent) throws SystemException {
        return query.searchUsersByIdEvent(idEvent);
    }
    public UserModel getUserByidUser(int idUser) throws SystemException {
        return query.searchUsersByIdUser(idUser);
    }
    public boolean checkUsername(String username) throws SystemException {
        return query.checkUsernameAlreadyTaken(username);
    }
}
