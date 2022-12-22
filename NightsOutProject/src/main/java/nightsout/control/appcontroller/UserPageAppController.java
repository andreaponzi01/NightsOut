package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.exception.myexception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class UserPageAppController {
    private UserPageAppController(){
        //ignore
    }

    public static List<EventBean1> searchNextEventsByIdUser(int idUser) throws SystemException {

        List<EventModel> list = null;
        List<EventBean1> listBean = null;
        list = EventDAO.getNextEventsByIdUser(idUser);
        listBean = new ArrayList<>();

        for(EventModel eventModel : list){
            EventBean1 bean = new EventBean1(eventModel);
            listBean.add(bean);
        }
        return listBean;

    }

    public static List<EventBean1> searchEndedEventsByIdUser(int idUser) throws SystemException {

        List<EventModel> list = null;
        List<EventBean1> listBean = null;
        list = EventDAO.getEndedEventsByIdUser(idUser);
        listBean = new ArrayList<>();

        for(EventModel eventModel : list){
            EventBean1 bean = new EventBean1(eventModel);
            listBean.add(bean);
        }
        return listBean;

    }
}
