package nightsout.utils.bean;

import nightsout.model.UserModel;

public class LoggedUserBean extends UserBean {

    public LoggedUserBean() {
        super();
    }

    public LoggedUserBean(UserModel um) {
        super(um);
    }

    private static LoggedUserBean loggedUserBeanInstance;

    public static LoggedUserBean getInstance() {
        return loggedUserBeanInstance;
    }

}
