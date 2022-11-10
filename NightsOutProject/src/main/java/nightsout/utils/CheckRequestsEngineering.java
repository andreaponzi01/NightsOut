package nightsout.utils;

import nightsout.control.appcontroller.CheckRequestsAppController;
import nightsout.utils.bean.RequestBean;

import java.util.List;

public class CheckRequestsEngineering {

    private CheckRequestsEngineering() {
        //ignored
    }

    public static void checkRequests(Observer observer, int idUser) {

        RequestBeanList list = new RequestBeanList(observer);
        list.addRequestsToList(searchRequests(idUser));
    }

    private static List<RequestBean> searchRequests(int idUser) {
        return (CheckRequestsAppController.searchRequestsByIdUser(idUser));
    }
}
