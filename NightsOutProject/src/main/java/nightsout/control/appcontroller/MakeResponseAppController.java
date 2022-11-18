package nightsout.control.appcontroller;

import nightsout.model.ResponseModel;
import nightsout.model.ReviewModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.dao.ResponseDAO;
import nightsout.utils.dao.ReviewDAO;
import nightsout.utils.dao.UserDAO;

import java.sql.SQLException;

public class MakeResponseAppController {

    private MakeResponseAppController() {
        //ignored
    }

    public static void makeResponse(ResponseBean responseBean) {
        ResponseModel responseModel = new ResponseModel(responseBean);
        ResponseDAO.createResponse(responseModel);
    }

    public static EventBean searchEventbyIdEvent(int idEvent) {
        EventBean eventBean= new EventBean(EventDAO.getEventByIdEvent(idEvent));
        return eventBean;

    }
}
