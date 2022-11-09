package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.dao.EventDAO;

public class CreateEventAppController {

    private CreateEventAppController() {
        //ignored
    }
    public static void createEvent(EventBean eventBean) {
        EventModel eventModel = new EventModel(eventBean);
        EventDAO.createEvent(eventModel);
    }

}
