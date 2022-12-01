package nightsout.utils.bean;

import nightsout.model.ClubOwnerModel;
import nightsout.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class LoggedClubOwnerBean extends ClubOwnerBean {

    private LoggedClubOwnerBean() {
        super();
    }

    private LoggedClubOwnerBean(ClubOwnerModel um) {
        super(um);
    }

    private static LoggedClubOwnerBean loggedCOBeanInstance;

    //not used
    public static LoggedClubOwnerBean getInstance() {
        if (loggedCOBeanInstance == null)
            loggedCOBeanInstance = new LoggedClubOwnerBean();
        return loggedCOBeanInstance;
    }

    public static LoggedClubOwnerBean getInstance(ClubOwnerModel um) {
        if (loggedCOBeanInstance == null)
            loggedCOBeanInstance = new LoggedClubOwnerBean(um);
        return loggedCOBeanInstance;
    }

    public static void DeleteInstance() {
        loggedCOBeanInstance=null;
    }

    public static String checkInstanceType() {
        if (loggedCOBeanInstance == null) {
            return "FREE";
        }
        else{
            return "CLUB OWNER";
        }
    }
}
