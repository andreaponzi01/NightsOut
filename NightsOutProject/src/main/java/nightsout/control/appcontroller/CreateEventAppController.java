package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.exception.myexception.SystemException;

public class CreateEventAppController {

    private CreateEventAppController() {
        //ignored
    }
    public static void createEvent(EventBean eventBean) throws SystemException {

        EventModel eventModel = new EventModel(eventBean);
        EventDAO.createEvent(eventModel);
    }

}
