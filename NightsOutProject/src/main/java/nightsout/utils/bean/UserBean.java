package nightsout.utils.bean;

import nightsout.model.UserModel;

public class UserBean extends ProfileBean {

    //Attributi User
    protected String surname;
    protected String gender;


    public UserBean(UserModel userModel) {

        /*
        **  I setter  dovrebbero essere utilizzati solo esternamente alla classe (?)
        */

        this.setSurname(userModel.getSecondName());
        this.setUsername(userModel.getUsername());
        this.setGender(userModel.getGender());
        this.setPassword(userModel.getPassword());
        //this.setEmail(userModel.getEmail());
        this.setId(userModel.getId());
        this.setType(userModel.getType());
        this.setImg((userModel.getProfileImg()));
    }

    // Getter
    public String getSurname() {return surname;}
    public String getGender() {return gender;}

    // Setter
    public void setSurname(String surname) { this.surname = surname; }
    public void setGender(String gender) { this.gender = gender; }

}
