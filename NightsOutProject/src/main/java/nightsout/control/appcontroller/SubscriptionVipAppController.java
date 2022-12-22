package nightsout.control.appcontroller;

import nightsout.model.UserModel;
import nightsout.utils.bean.LoggedUserBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.SystemException;

public class SubscriptionVipAppController {

    private SubscriptionVipAppController() {
        //ignored
    }

    public static void subscription(UserBean1 userBean) throws SystemException {

        UserModel userModel = new UserModel(userBean);
        userModel= UserDAO.subscriptionVip(userModel);
        LoggedUserBean1.updateInstance(userModel);
    }
}
