package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.utils.Email;
import nightsout.utils.bean.EventBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.exception.myexception.EmailException;
import nightsout.utils.exception.myexception.SystemException;

public class CreateEventAppController {

    private CreateEventAppController() {
        //ignored
    }
    public static void createEvent(EventBean eventBean) throws SystemException {
        EventModel eventModel = new EventModel(eventBean);
        EventDAO.createEvent(eventModel);

        try {
            Email.sendEmail("Evento creato con successo!", "L'evento " + eventBean.getName() + " è stato creato con successo.");
        } catch (EmailException e) {
            CreateNotification.createNotification(e);
        }
    }

}
