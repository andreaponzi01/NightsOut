package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.RequestDAO;
import nightsout.utils.exception.myexception.SystemException;

public class RequestAppController {

    private RequestAppController() {
        //ignored
    }

    public static void sendRequest(UserBean userBean, EventBean eventBean) throws SystemException {
        UserModel userModel = new UserModel(userBean);
        EventModel eventModel = new EventModel(eventBean);
        RequestDAO.createRequest(userModel, eventModel);
    }

}
