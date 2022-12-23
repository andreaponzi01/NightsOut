package nightsout.utils.bean;

import nightsout.model.UserModel;
import nightsout.utils.bean.interface2.UserBean2;

public class LoggedUserBean2 extends UserBean2 {

    private LoggedUserBean2() {
        super();
    }

    private LoggedUserBean2(UserModel um) {
        super(um);
    }

    private static LoggedUserBean2 loggedUserBeanInstance;

    public static LoggedUserBean2 getInstance() {

        if (loggedUserBeanInstance == null)
            loggedUserBeanInstance = new LoggedUserBean2();
        return loggedUserBeanInstance;
    }

    public static LoggedUserBean2 getInstance(UserModel um) {
        if (loggedUserBeanInstance == null)
            loggedUserBeanInstance = new LoggedUserBean2(um);
        return loggedUserBeanInstance;
    }

    public static void deleteInstance() {
        loggedUserBeanInstance = null;
    }

    public static void updateInstance(UserModel um) {

        loggedUserBeanInstance = null;
        loggedUserBeanInstance = new LoggedUserBean2(um);

    }
}
