package nightsout.control.appcontroller;

import nightsout.model.UserModel;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.SystemException;

public class SubscriptionVipAppController {

    public UserModel subscription(UserBean userBean) throws SystemException {

        UserModel userModel = new UserModel(userBean);
        UserDAO userDAO = new UserDAO();
        return userDAO.subscriptionVip(userModel);
    }
}
