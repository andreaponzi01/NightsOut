package nightsout.model;

import nightsout.utils.bean.EventBean;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventModel {


    public EventModel(){
        //ignore
    }

    protected int idEvent;
    protected int idClubOwner;

    protected String name;
    protected Double price;
    protected LocalTime time;
    protected int duration;
    protected LocalDate eventDate;

    public EventModel(EventBean eventBean) {
        this.idEvent = eventBean.getIdEvent();
        this.idClubOwner = eventBean.getIdClubOwner();
        this.eventDate = eventBean.getEventDate();
        this.price = eventBean.getPrice();
        this.name = eventBean.getName();
        this.duration = eventBean.getDuration();
        this.time = eventBean.getTime();
    }

    //Attributi User

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

    public void setPrice(Double price) {
        this.price = price;
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

    public LocalTime getTime() { return time; }

    public void setTime(LocalTime time) { this.time = time; }


}
