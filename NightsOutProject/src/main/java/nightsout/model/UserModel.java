package nightsout.model;

import nightsout.utils.bean.UserBean;

import java.io.File;
import java.time.LocalDate;

public class UserModel extends ProfileModel {
    private String name;
    private String surname;
    private String gender;
    private LocalDate birthday;
    private LocalDate creationDateVip;
    private boolean vip;



    private File img;

    public UserModel(){
        super();
    }

    public UserModel(UserBean userBean){

        super(userBean.getUsername(), userBean.getEmail(), userBean.getId(), userBean.getImg());
        this.name = userBean.getName();
        this.surname = userBean.getSurname();
        this.gender = userBean.getGender();
        this.birthday = userBean.getBirthday();
        this.img = userBean.getImg();

    }


    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) { this.surname = surname; }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(LocalDate birthday) { this.birthday = birthday; }

   public File getImg() {
        return img;
    }

    public void setImg(File img) {
        this.img = img;
    }


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
