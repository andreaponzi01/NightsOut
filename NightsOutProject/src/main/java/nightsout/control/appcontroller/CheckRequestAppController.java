package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.model.RequestModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.RequestDAO;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.RequestBeanList;

public class CheckRequestAppController {

    public RequestBean checkRequestStatus(UserBean userBean, EventBean eventBean) throws SystemException {

        UserModel userModel = new UserModel(userBean);
        EventModel eventModel = new EventModel(eventBean);
        RequestDAO requestDAO = new RequestDAO();
        RequestModel requestModel = requestDAO.checkRequestStatus(userModel, eventModel);
        if(requestModel==null)
            return null;
        return (new RequestBean(requestModel));
    }

    public void checkRequests(Observer observer, int idUser) throws SystemException {

        JoinEventAppController controller = new JoinEventAppController();
        RequestBeanList list = new RequestBeanList(observer);
        list.addRequestsToList(controller.searchRequestsByIdUser(idUser));
    }
}
