package nightsout.utils.bean;

import nightsout.model.EventModel;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.WrongInputTypeException;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventBean implements GenericBean {

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
    }

    protected int idEvent;
    protected int idClubOwner;
    protected String name;
    protected Double price;
    protected Double vipPrice;
    protected String description;


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
            Trigger.emptyField("Name");
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(String price) throws WrongInputTypeException, EmptyInputException {
        try {
            if (price.equals(""))
                Trigger.emptyField("Price");
            this.price = Double.valueOf(price);
        } catch(NumberFormatException e) {
            Trigger.throwWrongInputTypeException(e, "Price");
        }
    }

    public int getHours() {
        return hours;
    }

    public void setHours(String hours) throws WrongInputTypeException, EmptyInputException {
        try {
            if (hours.equals(""))
                Trigger.emptyField("Hours");
            this.hours = Integer.parseInt(hours);
        } catch (NumberFormatException e) {
            Trigger.throwWrongInputTypeException(e, "Hours");
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) throws WrongInputTypeException, EmptyInputException {
        try {
            if (minutes.equals(""))
                Trigger.emptyField("Minutes");
            this.minutes = Integer.parseInt(minutes);
        } catch (NumberFormatException e) {
            Trigger.throwWrongInputTypeException(e, "Minutes");
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) throws EmptyInputException {
        if (eventDate == null)
            Trigger.emptyField("Date");
        this.eventDate = eventDate;
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
