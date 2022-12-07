package nightsout.control.appcontroller;

import nightsout.model.UserModel;
import nightsout.utils.bean.LoggedUserBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.exception.myexception.SystemException;

public class SubscriptionVipAppController {

    private SubscriptionVipAppController() {
        //ignored
    }

    public static void subscription(UserBean userBean) throws SystemException {
        UserModel userModel = new UserModel(userBean);
        userModel= UserDAO.subscriptionVip(userModel);
        LoggedUserBean.updateInstance(userModel);
    }
}
