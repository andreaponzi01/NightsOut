package nightsout.utils.engineering;

import nightsout.utils.bean.UsernameBean;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.SystemException;

public class RegistrationEngineering {

    public boolean usernameAlreadyTaken(UsernameBean username) throws SystemException {
        UserDAO userDAO = new UserDAO();
        return userDAO.checkUsername(username.getUsername());
    }

}
