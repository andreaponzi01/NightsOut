package nightsout.control.appcontroller;

import nightsout.model.UserModel;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.UserDAO;

public class SubscriptionVipAppController {

    private SubscriptionVipAppController() {
        //ignored
    }

    public static UserBean subscription(String username) {
        UserModel userModel = new UserModel(username);
        UserDAO.subscriptionVip(userModel);
        UserBean userBean = new UserBean(userModel);

        return userBean;
    }
}
