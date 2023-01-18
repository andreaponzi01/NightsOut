package nightsout.utils;

import nightsout.model.ClubOwnerModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.UserBean;

public class Session {

    private static final String TYPE_FREE = "Free";
    private static final String TYPE_CLUB_OWNER = "ClubOwner";

    private Session() {}

    private static Session session;
    private UserBean userBean;
    private ClubOwnerBean clubOwnerBean;
    private String type;


    public static Session getInstance() {
        if (session == null)
            session = new Session();
        return session;
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
