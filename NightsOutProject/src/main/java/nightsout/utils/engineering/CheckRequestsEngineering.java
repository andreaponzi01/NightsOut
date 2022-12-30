package nightsout.utils.engineering;

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

    public static void checkRequests(Observer observer, int idUser) throws SystemException {
        RequestBeanList list = new RequestBeanList(observer);
        list.addRequestsToList(searchRequests(idUser));
    }

    private static List<RequestBean> searchRequests(int idUser) throws SystemException {
        return (CheckRequestsAppController.searchRequestsByIdUser(idUser));
    }
}
