package nightsout.utils;

import nightsout.control.appcontroller.ManageRequestsAppController;
import nightsout.utils.bean.ManageRequestBean;

import java.util.List;

public class ManageRequestsEngineering {

    private ManageRequestsEngineering() {
        //ignored
    }

    public static void manageRequests(Observer observer, int idClubOwner) {

        ManageRequestBeanList list = new ManageRequestBeanList(observer);
        list.addRequestsToList(searchRequests(idClubOwner));
    }

    private static List<ManageRequestBean> searchRequests(int idClubOwner) {
        return (ManageRequestsAppController.searchRequestsByIdClubOwner(idClubOwner));
    }

}
