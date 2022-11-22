package nightsout.utils.bean;

import nightsout.model.UserModel;

import java.time.LocalDate;

public class UserBean extends ProfileBean {

    //Attributi User
    protected String surname;
    protected String gender;

    protected LocalDate birthday;

    protected LocalDate creationDateVIP;

    protected boolean vip;

    public UserBean(){
        setType("Free");
    }

    public UserBean(UserModel userModel) {

        this.setSurname(userModel.getSurname());
        this.setName(userModel.getName());
        this.setUsername(userModel.getUsername());
        this.setGender(userModel.getGender());
        this.setPassword(userModel.getPassword());
        this.setEmail(userModel.getEmail());
        this.setId(userModel.getId());
        //this.setType(userModel.getType());
        this.setImg((userModel.getProfileImg()));
        this.setBirthday(userModel.getBirthday());
        this.setVip(userModel.getVip());
        this.setCreationDateVIP(userModel.getCreationDateVip());

        this.setType("Free");
    }

    // Getter
    public String getSurname() {return surname;}
    public String getGender() {return gender;}

    public LocalDate getBirthday() { return birthday; }

    // Setter
    public void setSurname(String surname) { this.surname = surname; }
    public void setGender(String gender) { this.gender = gender; }

    public void setBirthday(LocalDate birthday) { this.birthday = birthday; }

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
