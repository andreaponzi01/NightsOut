package nightsout.utils.engineering;

import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.SystemException;

public class RegistrationEngineering {

    public boolean usernameAlreadyTaken(String username) throws SystemException {
        UserDAO userDAO = new UserDAO();
        return userDAO.checkUsername(username);
    }

}
