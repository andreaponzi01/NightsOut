package nightsout.utils.bean.interface1;

import nightsout.model.EventModel;
import nightsout.utils.bean.EventBean;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.BeforeDateException;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.WrongInputRangeException;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventBean1 extends EventBean {

    private static final String FIELD_HOURS = "Hours";
    private static final String FIELD_MINUTES = "Minutes";
    private static final String FIELD_DATE = "Date";



    public EventBean1(){
        super();
    }

    public EventBean1(EventBean eventBean) {
        super(eventBean);
    }

    public EventBean1(EventModel eventModel) {
        super(eventModel);
    }


    public void setTime(String hours, String minutes) throws EmptyInputException, WrongInputRangeException {
        if (hours.equals("")) {
            Trigger.throwEmptyInputException(FIELD_HOURS);
        } else if (minutes.equals("")) {
            Trigger.throwEmptyInputException(FIELD_MINUTES);
        } else if (Integer.parseInt(hours) < 0 || Integer.parseInt(hours) > 24) {
            Trigger.throwExceededRangeException(FIELD_HOURS);
        } else if (Integer.parseInt(minutes) < 0 || Integer.parseInt(minutes) > 60) {
            Trigger.throwExceededRangeException(FIELD_MINUTES);
        }

        this.time = LocalTime.of(Integer.parseInt(hours), Integer.parseInt(minutes));
    }



    public void setEventDate(LocalDate eventDate) throws EmptyInputException, BeforeDateException {

        if (eventDate == null) {
            Trigger.throwEmptyInputException(FIELD_DATE);
        } else {
            if (eventDate.isBefore(LocalDate.now()))
                Trigger.throwBeforeDateException();
            this.eventDate = eventDate;
        }
    }
}
