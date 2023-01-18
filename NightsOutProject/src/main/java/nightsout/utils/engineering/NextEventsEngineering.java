package nightsout.utils.engineering;

import nightsout.model.EventModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.GenericBeanList;
import nightsout.utils.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class NextEventsEngineering {

    public void nextEvents(Observer observer, int idUser) throws SystemException {

        GenericBeanList list= new GenericBeanList(observer);
        list.addEventsToList(searchNextEventsByIdUser(idUser));
    }

    public List<EventBean> searchNextEventsByIdUser(int idUser) throws SystemException {

        List<EventModel> list = null;
        List<EventBean> listBean = null;
        EventDAO eventDAO = new EventDAO();
        list = eventDAO.getNextEventsByIdUser(idUser);
        listBean = new ArrayList<>();
        for(EventModel eventModel : list){
            EventBean bean = new EventBean(eventModel);
            listBean.add(bean);
        }
        return listBean;
    }
}
