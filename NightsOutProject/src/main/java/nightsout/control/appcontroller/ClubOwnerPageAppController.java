package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.exception.myexception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class ClubOwnerPageAppController {
    private ClubOwnerPageAppController(){
        //ignore
    }

    public static List<EventBean1> searchCreatedEventsByIdClubOwner(int idClubOwner) throws SystemException {

        List<EventModel> list = EventDAO.getCreatedEventsByIdClubOwner(idClubOwner);
        List<EventBean1>  listBean = new ArrayList<>();

        for(EventModel eventModel : list){
            EventBean1 bean = new EventBean1(eventModel);
            listBean.add(bean);
        }
        return listBean;

    }

}
