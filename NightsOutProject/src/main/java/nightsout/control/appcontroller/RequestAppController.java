package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.dao.RequestDAO;
import nightsout.utils.exception.myexception.SystemException;

public class RequestAppController {

    private RequestAppController() {
        //ignored
    }

    public static void sendRequest(UserBean1 userBean, EventBean1 eventBean) throws SystemException {

        UserModel userModel = new UserModel(userBean);
        EventModel eventModel = new EventModel(eventBean);
        RequestDAO.createRequest(userModel, eventModel);
    }

}
