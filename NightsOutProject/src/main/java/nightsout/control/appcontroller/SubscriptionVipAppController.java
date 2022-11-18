package nightsout.control.appcontroller;

import nightsout.model.UserModel;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.UserDAO;

import java.sql.SQLException;

public class SubscriptionVipAppController {

    private SubscriptionVipAppController() {
        //ignored
    }

    public static UserBean subscription(UserBean userBean) throws SQLException {
        UserModel userModel = new UserModel(userBean);

        UserDAO.subscriptionVip(userModel);
        return (new UserBean(userModel));
    }
}
