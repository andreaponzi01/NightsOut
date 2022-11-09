package nightsout.control.appcontroller;

import nightsout.model.UserModel;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.UserDAO;

import java.sql.SQLException;

public class SubscriptionVipAppController {

    private SubscriptionVipAppController() {
        //ignored
    }

    public static UserBean subscription(String username) throws SQLException {
        UserModel userModel = new UserModel(username);
        UserDAO.subscriptionVip(userModel);

        return (new UserBean(userModel));
    }
}
