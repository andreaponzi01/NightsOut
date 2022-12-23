package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.model.RequestModel;
import nightsout.utils.bean.EventBean;
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

    public static List<RequestBean> searchRequestsByIdUser(int idUser) throws SystemException {

        List<RequestModel> list = RequestDAO.getRequestsByIdUser(idUser);
        List<RequestBean> listBean = new ArrayList<>();
        for(RequestModel rm : list){
            RequestBean bean = new RequestBean(rm);
            listBean.add(bean);
        }
        return listBean;
    }

    public static EventBean searchEventByIdEvent(int idEvent) throws SystemException {
       EventModel eventModel = EventDAO.getEventByIdEvent(idEvent);
       return new EventBean(eventModel);
    }
}
