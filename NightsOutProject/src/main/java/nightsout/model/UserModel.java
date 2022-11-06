package nightsout.model;

import nightsout.utils.bean.Credentials;
import nightsout.utils.bean.UserBean;

import java.time.LocalDate;

public class UserModel extends ProfileModel {
    private String name;
    private String surname;
    private String gender;
    private LocalDate birthday;
    private LocalDate creationDateVip;
    private boolean vip;

    /*
       Mancano: data della sottoscrizione VIP
     */

    public UserModel(String username){ super(username); }

    public UserModel(UserBean userBean, Credentials myCred){

        super(myCred, userBean.getEmail());
        this.name = userBean.getName();
        this.surname = userBean.getSurname();
        this.gender = userBean.getGender();
        this.birthday = userBean.getBirthday();

    }

    /*
    public UserModel(Credentials cred, String name, File profileImg ) {
        super(cred, profileImg) ;
        setName(name);
    }
     */

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) { this.surname = surname; }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(LocalDate birthday) { this.birthday = birthday; }


    public String getName() {return name;}

    public String getSurname() { return surname; }
    public String getGender() {
        return gender;
    }

    public LocalDate getBirthday() { return birthday; }

    public boolean getVip() { return vip; }

    public void setVip(boolean vip) { this.vip = vip; }

    public LocalDate getCreationDateVip() {
        return creationDateVip;
    }

    public void setCreationDateVip(LocalDate creationDateVip) {
        this.creationDateVip = creationDateVip;
    }
}
