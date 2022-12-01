package nightsout.utils.bean;

import nightsout.model.UserModel;

// Singleton
import static java.lang.Boolean.TRUE;

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

    public static void DeleteInstance() {
        loggedUserBeanInstance=null;
    }
    public static void UpdateInstance(UserModel um) {
        loggedUserBeanInstance=null;
        loggedUserBeanInstance = new LoggedUserBean(um);

    }


}
