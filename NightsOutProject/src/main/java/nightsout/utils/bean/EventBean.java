package nightsout.utils.bean;

import nightsout.model.EventModel;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.BeforeDateException;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.WrongInputRangeException;
import nightsout.utils.exception.myexception.WrongInputTypeException;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

public class EventBean implements GenericBean {

    private static final String FIELD_PRICE = "Price";
    private static final String FIELD_HOURS = "Hourse";
    private static final String FIELD_MINUTES = "Minutes";
    private static final String FIELD_DATE = "Date";
    private static final String FIELD_IMAGE = "Image";



    public EventBean(){
    }

    public EventBean(EventModel eventModel) {
        this.name = eventModel.getName();
        this.idEvent = eventModel.getIdEvent();
        this.idClubOwner = eventModel.getIdClubOwner();
        this.price = eventModel.getPrice();
        this.eventDate = eventModel.getEventDate();
        this.duration = eventModel.getDuration();
        this.hours = eventModel.getTime().getHour();
        this.minutes = eventModel.getTime().getMinute();
        this.description = eventModel.getDescription();
        this.img = eventModel.getImg();
    }

    protected int idEvent;
    protected int idClubOwner;
    protected String name;
    protected Double price;
    protected Double vipPrice;
    protected String description;

    protected File img;
    protected int hours;
    protected int minutes;
    protected int duration;
    protected LocalDate eventDate;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description = description;
    }


    public int getIdClubOwner() {
        return idClubOwner;
    }

    public void setIdClubOwner(int idClubOwner) {
        this.idClubOwner = idClubOwner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws EmptyInputException {

        if (name.equals(""))
            Trigger.throwEmptyInputException("Name");
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(String price) throws WrongInputTypeException, EmptyInputException {

        try {
            if (price.equals(""))
                Trigger.throwEmptyInputException(FIELD_PRICE);
            this.price = Double.valueOf(price);
        } catch(NumberFormatException e) {
            Trigger.throwWrongInputTypeException(e, FIELD_PRICE);
        }
    }

    public int getHours() {
        return hours;
    }

    public void setHours(String hours) throws WrongInputTypeException, EmptyInputException, WrongInputRangeException {

        try {
            if (hours.equals(""))
                Trigger.throwEmptyInputException(FIELD_HOURS);
            if(Integer.parseInt(hours) < 0 || Integer.parseInt(hours) > 12)
                Trigger.throwExceededRangeException(FIELD_HOURS);
            this.hours = Integer.parseInt(hours);
        } catch (NumberFormatException e) {
            Trigger.throwWrongInputTypeException(e, FIELD_HOURS);
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) throws WrongInputTypeException, EmptyInputException, WrongInputRangeException {

        try {
            if (minutes.equals(""))
                Trigger.throwEmptyInputException(FIELD_MINUTES);
            if(Integer.parseInt(minutes) < 0 || Integer.parseInt(minutes) > 59)
                Trigger.throwExceededRangeException(FIELD_MINUTES);
            this.minutes = Integer.parseInt(minutes);
        } catch (NumberFormatException e) {
            Trigger.throwWrongInputTypeException(e, FIELD_MINUTES);
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public File getImg() {
        return img;
    }

    public void setImg(File img) throws EmptyInputException {
        if (img == null) {
            Trigger.throwEmptyInputException(FIELD_IMAGE);
        } else {
            this.img = img;
        }
    }

    public LocalDate getEventDate() {
        return eventDate;
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

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public LocalTime getTime() {
        return LocalTime.of(this.hours, this.minutes);
    }
}
