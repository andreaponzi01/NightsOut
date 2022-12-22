package nightsout.utils.bean;

import nightsout.model.ClubOwnerModel;
import nightsout.utils.bean.interface1.ClubOwnerBean1;

public class LoggedClubOwnerBean1 extends ClubOwnerBean1 {

    private static final String TYPE_FREE = "FREE";
    private static final String TYPE_CLUB_OWNER = "CLUB OWNER";

    private LoggedClubOwnerBean1() {
        super();
    }

    private LoggedClubOwnerBean1(ClubOwnerModel um) {
        super(um);
    }

    private static LoggedClubOwnerBean1 loggedCOBeanInstance;

    //not used
    public static LoggedClubOwnerBean1 getInstance() {
        if (loggedCOBeanInstance == null)
            loggedCOBeanInstance = new LoggedClubOwnerBean1();
        return loggedCOBeanInstance;
    }

    public static LoggedClubOwnerBean1 getInstance(ClubOwnerModel com) {
        if (loggedCOBeanInstance == null)
            loggedCOBeanInstance = new LoggedClubOwnerBean1(com);
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
        loggedCOBeanInstance = new LoggedClubOwnerBean1(clubOwnerModel);
    }
}
