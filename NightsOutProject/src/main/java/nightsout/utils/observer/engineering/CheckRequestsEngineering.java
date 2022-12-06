package nightsout.utils.observer.engineering;

import nightsout.control.appcontroller.CheckRequestsAppController;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.RequestBeanList;

import java.sql.SQLException;
import java.util.List;

public class CheckRequestsEngineering {

    private CheckRequestsEngineering() {
        //ignored
    }

    public static void checkPendingRequests(Observer observer, int idUser) throws SQLException, SystemException {
        RequestBeanList list = new RequestBeanList(observer);
        list.addRequestsToList(searchPendingRequests(idUser));
    }

    public static void checkAllRequests(Observer observer, int idUser) throws SQLException, SystemException {
        RequestBeanList list = new RequestBeanList(observer);
        list.addRequestsToList(searchRequests(idUser));
    }

    private static List<RequestBean> searchRequests(int idUser) {
        return (CheckRequestsAppController.searchRequestsByIdUser(idUser));
    }

    private static List<RequestBean> searchPendingRequests(int idUser) {
        return (CheckRequestsAppController.searchPendingRequestsByIdUser(idUser));
    }
}
