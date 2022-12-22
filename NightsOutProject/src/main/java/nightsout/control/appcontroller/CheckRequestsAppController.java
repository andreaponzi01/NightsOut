package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.model.RequestModel;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.dao.RequestDAO;
import nightsout.utils.exception.myexception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class CheckRequestsAppController {

    private CheckRequestsAppController() {
        //ignored
    }
    public static List<RequestBean> searchRifiutedRequestsByIdUser(int idUser) throws SystemException {

        List<RequestModel> list = RequestDAO.getRifiutedRequestsByIdUser(idUser);
        List<RequestBean> listBean = new ArrayList<>();

        for(RequestModel rm : list){
            RequestBean bean = new RequestBean(rm);
            listBean.add(bean);
        }
        return listBean;
    }

    public static List<RequestBean> searchPendingRequestsByIdUser(int idUser) throws SystemException {

        List<RequestModel> list = RequestDAO.getPendingRequestsByIdUser(idUser);
        List<RequestBean> listBean = new ArrayList<>();

        for(RequestModel rm : list){
            RequestBean bean = new RequestBean(rm);
            listBean.add(bean);
        }

    return listBean;
    }

    public static EventBean1 searchEventById(int idEvent) throws SystemException {
       EventModel eventModel = EventDAO.getEventByIdEvent(idEvent);
        return new EventBean1(eventModel);
    }
}
