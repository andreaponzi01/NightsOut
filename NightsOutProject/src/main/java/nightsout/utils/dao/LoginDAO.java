package nightsout.utils.dao;

import nightsout.model.CredentialsModel;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.SystemException;

public class LoginDAO {

    private LoginDAO() {
        //ignored
    }
    public static boolean checkIsRegistered(CredentialsModel credentialsModel) throws SystemException {
        return Query.searchUserInLogged(credentialsModel);
    }
}
