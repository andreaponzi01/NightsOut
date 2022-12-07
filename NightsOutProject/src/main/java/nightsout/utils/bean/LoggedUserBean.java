package nightsout.utils.bean;

import nightsout.model.UserModel;

public class LoggedUserBean extends UserBean {

    private LoggedUserBean() {
        super();
    }

    private LoggedUserBean(UserModel um) {
        super(um);
    }

    private static LoggedUserBean loggedUserBeanInstance;

    public static LoggedUserBean getInstance() {

        if (loggedUserBeanInstance == null)
            loggedUserBeanInstance = new LoggedUserBean();
        return loggedUserBeanInstance;
    }

    public static LoggedUserBean getInstance(UserModel um) {
        if (loggedUserBeanInstance == null)
            loggedUserBeanInstance = new LoggedUserBean(um);
        return loggedUserBeanInstance;
    }

    public static void deleteInstance() {
        loggedUserBeanInstance = null;
    }

    public static void updateInstance(UserModel um) {

        loggedUserBeanInstance = null;
        loggedUserBeanInstance = new LoggedUserBean(um);

    }

    public static void createInstance(UserModel userModel) {
        loggedUserBeanInstance = new LoggedUserBean(userModel);
    }
}
