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

    private static LoggedUserBean2 loggedUserBean2Instance;

    public static LoggedUserBean2 getInstance() {

        if (loggedUserBean2Instance == null)
            loggedUserBean2Instance = new LoggedUserBean2();
        return loggedUserBean2Instance;
    }

    public static LoggedUserBean2 getInstance(UserModel um) {
        if (loggedUserBean2Instance == null)
            loggedUserBean2Instance = new LoggedUserBean2(um);
        return loggedUserBean2Instance;
    }

    public static void deleteInstance() {
        loggedUserBean2Instance = null;
    }

    public static void updateInstance(UserModel um) {

        loggedUserBean2Instance = null;
        loggedUserBean2Instance = new LoggedUserBean2(um);

    }
}
