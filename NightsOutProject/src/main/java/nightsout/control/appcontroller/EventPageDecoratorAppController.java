package nightsout.control.appcontroller;

import nightsout.control.guicontroller.MyNotification;
import nightsout.model.EventModel;
import nightsout.model.RequestModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.dao.RequestDAO;
import nightsout.utils.exception.myexception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class EventPageDecoratorAppController {

    private EventPageDecoratorAppController() {
        //ignored
    }

    public static RequestBean checkRequestStatus(UserBean userBean, EventBean eventBean) throws SystemException {
        UserModel userModel = new UserModel(userBean);
        EventModel eventModel = new EventModel(eventBean);
        RequestModel requestModel = RequestDAO.checkRequestStatus(userModel, eventModel);
        if(requestModel==null)
            return null;
        return (new RequestBean(requestModel));
    }

    public static List<EventBean> searchEventsByIdClubOwner(int idClubOwner) {
        List<EventModel> list = null;
        List<EventBean> listBean = null;
        try {
            list = EventDAO.getCreatedEventsByIdClubOwner(idClubOwner);
            listBean = new ArrayList<>();

            for(EventModel um : list){
                EventBean bean = new EventBean(um);
                listBean.add(bean);
            }

        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
        return listBean;
    }


}
