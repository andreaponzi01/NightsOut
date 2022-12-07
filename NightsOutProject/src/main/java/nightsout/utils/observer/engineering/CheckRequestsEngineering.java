package nightsout.utils.observer.engineering;

import nightsout.control.appcontroller.CheckRequestsAppController;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.RequestBeanList;

import java.util.List;

public class CheckRequestsEngineering {

    private CheckRequestsEngineering() {
        //ignored
    }

    public static void checkPendingRequests(Observer observer, int idUser) throws SystemException {
        RequestBeanList list = new RequestBeanList(observer);
        list.addRequestsToList(searchPendingRequests(idUser));
    }

    public static void checkRifiutedRequests(Observer observer, int idUser) throws SystemException {
        RequestBeanList list = new RequestBeanList(observer);
        list.addRequestsToList(searchRifiutedRequests(idUser));
    }

    private static List<RequestBean> searchRifiutedRequests(int idUser) throws SystemException {
        return (CheckRequestsAppController.searchRifiutedRequestsByIdUser(idUser));
    }

    private static List<RequestBean> searchPendingRequests(int idUser) {
        return (CheckRequestsAppController.searchPendingRequestsByIdUser(idUser));
    }
}
