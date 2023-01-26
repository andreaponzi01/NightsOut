package nightsout.utils.engineering;

import nightsout.model.EventModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.IdBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.GenericBeanList;
import nightsout.utils.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ClubOwnerPageEngineering {

    private List<EventBean> searchCreatedEventsByIdClubOwner(int id) throws SystemException {

        EventDAO eventDAO = new EventDAO();
        List<EventModel> list = eventDAO.getCreatedEventsByIdClubOwner(id);
        List<EventBean>  listBean = new ArrayList<>();
        for(EventModel eventModel : list){
            EventBean bean = new EventBean(eventModel);
            listBean.add(bean);
        }
        return listBean;
    }

    public void createdEvents(Observer observer, IdBean idBean) throws SystemException {

        GenericBeanList list = new GenericBeanList(observer);
        ClubOwnerPageEngineering clubOwnerPageEngineering = new ClubOwnerPageEngineering();
        list.addEventsToList(clubOwnerPageEngineering.searchCreatedEventsByIdClubOwner(idBean.getId()));
    }
}
