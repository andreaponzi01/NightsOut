package nightsout.control.appcontroller;

import nightsout.model.ResponseModel;
import nightsout.model.ReviewModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.dao.ResponseDAO;
import nightsout.utils.dao.ReviewDAO;
import nightsout.utils.exception.myexception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class MakeResponseAppController {

    private MakeResponseAppController() {
        //ignored
    }
    public static void makeResponse(ResponseBean responseBean) throws SystemException {
        ResponseModel responseModel = new ResponseModel(responseBean);
        ResponseDAO.createResponse(responseModel);
    }
    public static EventBean searchEventbyIdEvent(int idEvent) throws SystemException {return new EventBean(EventDAO.getEventByIdEvent(idEvent));    }

}
