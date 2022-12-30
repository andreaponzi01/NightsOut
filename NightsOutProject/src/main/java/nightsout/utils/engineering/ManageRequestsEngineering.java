package nightsout.utils.engineering;

import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.ManageRequestBeanList;
import nightsout.utils.observer.Observer;

import java.util.List;

public class ManageRequestsEngineering {

    private ManageRequestsEngineering() {
        //ignored
    }

    public static void manageRequests(Observer observer, int idClubOwner) throws SystemException {
        ManageRequestBeanList list = new ManageRequestBeanList(observer);
        list.addRequestsToList(searchRequests(idClubOwner));
    }

    private static List<ManageRequestBean> searchRequests(int idClubOwner) throws SystemException {
        return (JoinEventAppController.searchRequestsByIdClubOwner(idClubOwner));
    }

}
