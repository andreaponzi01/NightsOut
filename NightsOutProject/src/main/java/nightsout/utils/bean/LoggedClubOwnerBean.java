package nightsout.utils.bean;

import nightsout.model.ClubOwnerModel;

public class LoggedClubOwnerBean extends ClubOwnerBean {

    private static final String TYPE_FREE = "FREE";
    private static final String TYPE_CLUB_OWNER = "CLUB OWNER";

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

    public static LoggedClubOwnerBean getInstance(ClubOwnerModel com) {
        if (loggedCOBeanInstance == null)
            loggedCOBeanInstance = new LoggedClubOwnerBean(com);
        return loggedCOBeanInstance;
    }

    public static void deleteInstance() {
        loggedCOBeanInstance=null;
    }

    public static String checkInstanceType() {
        if (loggedCOBeanInstance == null) {
            return TYPE_FREE;
        }
        else{
            return TYPE_CLUB_OWNER;
        }
    }

    public static void createInstance(ClubOwnerModel clubOwnerModel) {
        loggedCOBeanInstance = new LoggedClubOwnerBean(clubOwnerModel);
    }
}
