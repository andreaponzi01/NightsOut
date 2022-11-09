package nightsout.utils.bean;

import nightsout.model.EventModel;

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
    }

    //Attributi User
    protected int idEvent;
    protected int idClubOwner;
    protected String name;
    protected Double price;
    protected int hours;
    protected int minutes;
    protected int duration;
    protected LocalDate eventDate;

    public int getIdClubOwner() {
        return idClubOwner;
    }

    public void setIdClubOwner(int idClubOwner) {
        this.idClubOwner = idClubOwner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) { this.price = price; }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
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

    public void setEventDate(LocalDate eventDate) {
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
