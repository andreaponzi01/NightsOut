package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.utils.Email;
import nightsout.utils.bean.EventBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.EmailException;
import nightsout.utils.exception.myexception.SystemException;

public class CreateEventAppController {

    public void createEvent(EventBean eventBean) throws SystemException {

        EventModel eventModel = new EventModel(eventBean);
        EventDAO eventDAO = new EventDAO();
        eventDAO.createEvent(eventModel);
        Email email;
        try {
            email = new Email();
            email.sendEmail("Evento creato con successo!", "L'evento " + eventBean.getName() + " è stato creato con successo.");
        } catch (EmailException e) {
            ExceptionHandler.getInstance().handleException(e);
        }
    }

}
