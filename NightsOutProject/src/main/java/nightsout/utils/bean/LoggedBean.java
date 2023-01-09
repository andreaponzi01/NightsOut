package nightsout.utils.bean;

import nightsout.model.ClubOwnerModel;
import nightsout.model.UserModel;

public class LoggedBean {

    private static final String TYPE_FREE = "Free";
    private static final String TYPE_CLUB_OWNER = "ClubOwner";

    private LoggedBean() {}

    private static LoggedBean loggedBeanInstance;
    private UserBean userBean;
    private ClubOwnerBean clubOwnerBean;
    private String type;


    public static LoggedBean getInstance() {
        if (loggedBeanInstance == null)
            loggedBeanInstance = new LoggedBean();
        return loggedBeanInstance;
    }

    public ClubOwnerBean getClubOwner() {
        return clubOwnerBean;
    }

    public UserBean getUser() {
        return userBean;
    }

    public void setClubOwner(ClubOwnerModel clubOwnerModel) {
        clubOwnerBean = new ClubOwnerBean(clubOwnerModel);
        type = TYPE_CLUB_OWNER;
    }

    public void setUser(UserModel userModel) {
        userBean = new UserBean(userModel);
        type = TYPE_FREE;
    }

    public void deleteSession() {
        clubOwnerBean = null;
        userBean = null;
        type = "";
    }

    public String checkInstanceType() {
        return type;
    }
}
