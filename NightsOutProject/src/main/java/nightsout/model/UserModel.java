package nightsout.model;

import nightsout.utils.bean.Credentials;

import java.io.File;

public class UserModel extends ProfileModel {
    private String name;
    private String surname="";
    private String gender="";

    /*
       Mancano: data della sottoscrizione VIP e data di nascita
     */

    public UserModel(String username){ super(username); }

    public UserModel(Credentials cred, String name, File profileImg ) {
        super(cred, profileImg) ;
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) { this.surname = surname; }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {return name;}
    public String getSecondName() { return surname; }
    public String getGender() {
        return gender;
    }
}
