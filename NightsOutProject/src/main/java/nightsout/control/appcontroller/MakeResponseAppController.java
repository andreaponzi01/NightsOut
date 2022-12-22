package nightsout.control.appcontroller;

import nightsout.model.ResponseModel;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.dao.ResponseDAO;
import nightsout.utils.exception.myexception.SystemException;

public class MakeResponseAppController {

    private MakeResponseAppController() {
        //ignored
    }

    public static void makeResponse(ResponseBean responseBean) throws SystemException {
        ResponseModel responseModel = new ResponseModel(responseBean);
        ResponseDAO.createResponse(responseModel);
    }

    public static EventBean1 searchEventbyIdEvent(int idEvent) throws SystemException {
        return new EventBean1(EventDAO.getEventByIdEvent(idEvent));

    }
}
