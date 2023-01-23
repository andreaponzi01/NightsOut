package nightsout.control.appcontroller;

import nightsout.model.EventModel;
import nightsout.utils.engineering.EmailEngineering;
import nightsout.utils.bean.EventBean;
import nightsout.utils.dao.EventDAO;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.CreateEventEmailException;
import nightsout.utils.exception.myexception.EmailException;
import nightsout.utils.exception.myexception.SystemException;

public class CreateEventAppController {

    public void createEvent(EventBean eventBean) throws CreateEventEmailException, SystemException {

        Trigger trigger = new Trigger();

        EventModel eventModel = new EventModel(eventBean);
        EventDAO eventDAO = new EventDAO();
        eventDAO.createEvent(eventModel);
        EmailEngineering email;
        try {
            email = new EmailEngineering();
            email.sendEmail("Evento creato con successo!", "L'evento " + eventBean.getName() + " è stato creato con successo.");
        } catch (EmailException e) {
            trigger.throwCreateEventEmailException(e);
        }
    }

}
