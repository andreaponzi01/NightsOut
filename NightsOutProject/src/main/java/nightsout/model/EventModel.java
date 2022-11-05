package nightsout.model;

import nightsout.utils.bean.EventBean;

import java.time.LocalDate;

public class EventModel {


    public EventModel(){
        //ignore
    }

    public EventModel(EventBean eventBean) {
        this.idClubOwner = eventBean.getIdClubOwner();
        this.eventDate = eventBean.getEventDate();
        this.price = eventBean.getPrice();
        this.name = eventBean.getName();
        this.duration = eventBean.getDuration();
        this.hours = eventBean.getHours();
        this.minutes = eventBean.getMinutes();
    }

    //Attributi User
    protected int idClubOwner;
    protected String name;
    protected Double price;

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

    protected int hours;
    protected int minutes;
    protected int duration;
    protected LocalDate eventDate;

}
