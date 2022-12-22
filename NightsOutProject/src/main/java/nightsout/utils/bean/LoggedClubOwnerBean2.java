package nightsout.utils.bean;

import nightsout.model.ClubOwnerModel;
import nightsout.utils.bean.interface2.ClubOwnerBean2;

public class LoggedClubOwnerBean2 extends ClubOwnerBean2 {

    private static final String TYPE_FREE = "FREE";
    private static final String TYPE_CLUB_OWNER = "CLUB OWNER";

    private LoggedClubOwnerBean2() {
        super();
    }

    private LoggedClubOwnerBean2(ClubOwnerModel um) {
        super(um);
    }

    private static LoggedClubOwnerBean2 loggedCOBeanInstance;

    //not used
    public static LoggedClubOwnerBean2 getInstance() {
        if (loggedCOBeanInstance == null)
            loggedCOBeanInstance = new LoggedClubOwnerBean2();
        return loggedCOBeanInstance;
    }

    public static LoggedClubOwnerBean2 getInstance(ClubOwnerModel com) {
        if (loggedCOBeanInstance == null)
            loggedCOBeanInstance = new LoggedClubOwnerBean2(com);
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
        loggedCOBeanInstance = new LoggedClubOwnerBean2(clubOwnerModel);
    }
}
