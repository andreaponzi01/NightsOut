package nightsout.utils.dao;

import nightsout.model.CredentialsModel;
import nightsout.utils.db.Query;
import nightsout.utils.exception.myexception.SystemException;

public class LoginDAO {

    Query query = new Query();
    public boolean checkIsRegistered(CredentialsModel credentialsModel) throws SystemException {
        return query.searchUserInLogged(credentialsModel);
    }
}
