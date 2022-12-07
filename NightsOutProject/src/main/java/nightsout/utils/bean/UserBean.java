package nightsout.utils.bean;

import nightsout.model.UserModel;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.AdultException;
import nightsout.utils.exception.myexception.EmptyInputException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class UserBean extends ProfileBean {

    //Attributi User
    protected String surname;
    protected String gender;
    protected LocalDate birthday;
    protected LocalDate creationDateVIP;
    protected boolean vip;


    public UserBean(){
    }

    public UserBean(UserModel userModel) {
        this.surname = userModel.getSurname();
        this.name = userModel.getName();
        this.username = userModel.getUsername();
        this.gender = userModel.getGender();
        this.email = userModel.getEmail();
        this.id = userModel.getId();
        this.img = userModel.getProfileImg();
        this.birthday = userModel.getBirthday();
        this.vip = userModel.getVip();
        this.creationDateVIP = userModel.getCreationDateVip();
    }

    // Getter
    public String getSurname() {return surname;}
    public String getGender() {return gender;}

    public LocalDate getBirthday() { return birthday;}

    // Setter
    public void setSurname(String surname) throws EmptyInputException {
        if (surname.equals(""))
            Trigger.throwEmptyInputException("Surname");
        this.surname = surname; }
    public void setGender(String gender) { this.gender = gender; }

    public void setBirthday(LocalDate birthday) throws AdultException, EmptyInputException {
        if (birthday == null) {
            Trigger.throwEmptyInputException("Date");
        } else {
            if (birthday.until(LocalDate.now(), ChronoUnit.YEARS) < 18)
                Trigger.throwAdultException();
            this.birthday = birthday;
        }
    }

    public boolean getVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public LocalDate getCreationDateVIP() {
        return creationDateVIP;
    }

    public void setCreationDateVIP(LocalDate creationDateVIP) {
        this.creationDateVIP = creationDateVIP;
    }

}
