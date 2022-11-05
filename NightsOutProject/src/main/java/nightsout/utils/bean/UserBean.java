package nightsout.utils.bean;

import nightsout.model.UserModel;

import java.time.LocalDate;

public class UserBean extends ProfileBean {

    //Attributi User
    protected String surname;
    protected String gender;

    protected LocalDate birthday;

    public UserBean(){
        //ignore
    }

    public UserBean(UserModel userModel) {

        /*
        **  I setter  dovrebbero essere utilizzati solo esternamente alla classe (?)
        */

        this.setSurname(userModel.getSurname());
        this.setUsername(userModel.getUsername());
        this.setGender(userModel.getGender());
        this.setPassword(userModel.getPassword());
        this.setEmail(userModel.getEmail());
        this.setId(userModel.getId());
        this.setType(userModel.getType());
        this.setImg((userModel.getProfileImg()));
        this.setBirthday(userModel.getBirthday());
    }

    // Getter
    public String getSurname() {return surname;}
    public String getGender() {return gender;}

    public LocalDate getBirthday() { return birthday; }

    // Setter
    public void setSurname(String surname) { this.surname = surname; }
    public void setGender(String gender) { this.gender = gender; }

    public void setBirthday(LocalDate birthday) { this.birthday = birthday; }

}
