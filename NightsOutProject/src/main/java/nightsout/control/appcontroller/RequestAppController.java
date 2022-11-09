package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.model.RequestModel;
import nightsout.model.UserModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.RequestDAO;

public class RequestAppController {

    private RequestAppController() {
        //ignored
    }

    public static void sendRequest(UserBean userBean, EventBean eventBean) {
        UserModel userModel = new UserModel(userBean);
        EventModel eventModel = new EventModel(eventBean);
        RequestDAO.createRequest(userModel, eventModel);
    }

    public static RequestBean checkRequestStatus(UserBean userBean, EventBean eventBean) {
        UserModel userModel = new UserModel(userBean);
        EventModel eventModel = new EventModel(eventBean);
        RequestModel requestModel = RequestDAO.checkRequestStatus(userModel, eventModel);
        return (new RequestBean(requestModel));
    }

}
