package nightsout.utils.bean.interface2;

import nightsout.utils.bean.EventBean;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.BeforeDateException;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.WrongInputTypeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class EventBean2 extends EventBean {

    public EventBean2(){
        super();
    }

    public void setEventDate(String date) throws EmptyInputException, BeforeDateException, WrongInputTypeException {

        if (date.equals("")) {
            Trigger.throwEmptyInputException("Event Date");
        } else {
            try {
                SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
                Date dateDate = formatter1.parse(date);
                LocalDate dateLocalDate = LocalDate.from(dateDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                if (dateLocalDate.isBefore(LocalDate.now()))
                    Trigger.throwBeforeDateException();
                else
                    this.eventDate = dateLocalDate;
            } catch (NumberFormatException e) {
                Trigger.throwWrongInputTypeException(e, "Birthday");
            } catch (DateTimeException e) {
                Trigger.throwWrongInputTypeException(new NumberFormatException(), "Event Date");
            } catch (ParseException e) {
                Trigger.throwWrongInputTypeException(new NumberFormatException(), "Event Date");
            }
        }
    }

    public void setTime(String time) throws EmptyInputException, WrongInputTypeException {
        if (time.equals("")) {
            Trigger.throwEmptyInputException("Event Time");
        } else {
            try {
                this.time = LocalTime.parse(time);
            } catch (DateTimeParseException e) {
                Trigger.throwWrongInputTypeException(new NumberFormatException(), "Minutes");
            }
        }
    }
}
