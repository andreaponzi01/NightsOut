package nightsout.utils.bean;

import nightsout.model.EventModel;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.WrongInputTypeException;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

public class EventBean implements GenericBean {

    protected Trigger trigger = new Trigger();

    private static final String FIELD_PRICE = "Price";
    private static final String FIELD_IMAGE = "Image";

    public EventBean() {
    }

    public EventBean(EventBean eventBean) {
        this.name = eventBean.getName();
        this.idEvent = eventBean.getIdEvent();
        this.idClubOwner = eventBean.getIdClubOwner();
        this.price = eventBean.getPrice();
        this.eventDate = eventBean.getEventDate();
        this.duration = eventBean.getDuration();
        this.time = eventBean.getTime();
        this.description = eventBean.getDescription();
        this.img = eventBean.getImg();
    }

    public EventBean(EventModel eventModel) {
        this.name = eventModel.getName();
        this.idEvent = eventModel.getIdEvent();
        this.idClubOwner = eventModel.getIdClubOwner();
        this.price = eventModel.getPrice();
        this.eventDate = eventModel.getEventDate();
        this.duration = eventModel.getDuration();
        this.time = eventModel.getTime();
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
    protected LocalTime time;
    protected int duration;
    protected LocalDate eventDate;


    public int getIdEvent() {
        return idEvent;
    }
    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }
    public LocalTime getTime() {
        return time;
    }
    public LocalDate getEventDate() {
        return eventDate;
    }
    public File getImg() {
        return img;
    }
    public int getDuration() {
        return duration;
    }
    public Double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public int getIdClubOwner() {
        return idClubOwner;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description = description;}



    public void setIdClubOwner(int idClubOwner) {
        this.idClubOwner = idClubOwner;
    }



    public void setName(String name) throws EmptyInputException {

        if (name.equals(""))
            trigger.throwEmptyInputException("Name");
        this.name = name;
    }

    public void setPrice(String price) throws WrongInputTypeException, EmptyInputException {

        try {
            if (price.equals(""))
                trigger.throwEmptyInputException(FIELD_PRICE);
            this.price = Double.valueOf(price);
        } catch(NumberFormatException e) {
            trigger.throwWrongInputTypeException(e, FIELD_PRICE);
        }
    }


    public void setDuration(int duration) {
        this.duration = duration;
    }



    public void setImg(File img) throws EmptyInputException {
        if (img == null) {
            trigger.throwEmptyInputException(FIELD_IMAGE);
        } else {
            this.img = img;
        }
    }

}
