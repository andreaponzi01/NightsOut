package nightsout.utils.bean.interface1;

import nightsout.model.UserModel;

public class LoggedUserBean1 extends UserBean1 {

    private LoggedUserBean1() {
        super();
    }

    private LoggedUserBean1(UserModel um) {
        super(um);
    }

    private static LoggedUserBean1 loggedUserBeanInstance;

    public static LoggedUserBean1 getInstance() {

        if (loggedUserBeanInstance == null)
            loggedUserBeanInstance = new LoggedUserBean1();
        return loggedUserBeanInstance;
    }

    public static LoggedUserBean1 getInstance(UserModel um) {
        if (loggedUserBeanInstance == null)
            loggedUserBeanInstance = new LoggedUserBean1(um);
        return loggedUserBeanInstance;
    }

    public static void deleteInstance() {
        loggedUserBeanInstance = null;
    }

    public static void updateInstance(UserModel um) {

        loggedUserBeanInstance = null;
        loggedUserBeanInstance = new LoggedUserBean1(um);

    }
}
