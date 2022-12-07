package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.exception.myexception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class ClubOwnerPageAppController {
    private ClubOwnerPageAppController(){
        //ignore
    }

    public static List<EventBean> searchCreatedEventsByIdClubOwner(int idClubOwner) throws SystemException {

        List<EventModel> list = EventDAO.getCreatedEventsByIdClubOwner(idClubOwner);
        List<EventBean>  listBean = new ArrayList<>();

        for(EventModel eventModel : list){
            EventBean bean = new EventBean(eventModel);
            listBean.add(bean);
        }
        return listBean;

    }

}
