package nightsout.control.appcontroller;

import nightsout.control.guicontroller.MyNotification;
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

    public static List<EventBean> searchCreatedEventsByIdClubOwner(int idClubOwner) {
        List<EventModel> list = null;
        List<EventBean> listBean = null;

        try {
            list = EventDAO.getCreatedEventsByIdClubOwner(idClubOwner);
            listBean = new ArrayList<>();

            for(EventModel eventModel : list){
                EventBean bean = new EventBean(eventModel);
                listBean.add(bean);
            }

        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
        return listBean;

    }

}
