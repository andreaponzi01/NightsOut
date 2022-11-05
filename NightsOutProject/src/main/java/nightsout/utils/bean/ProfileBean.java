package nightsout.utils.bean;

import java.io.File;

public abstract class ProfileBean {

    // Attributi comuni a User e ClubOwner
    protected String username;

    // Per gli Users rappresenta il nome (name), mentre per i ClubOwners rappresenta il nome del club (clubName)
    protected String name;
    protected String password;
    protected String email;
    protected String type;
    protected File img;
    protected int id;

    // Getter
    public String getUsername() {return username;}
    public String getName() {return name;}
    public String getPassword() {return password;}
    public String getEmail() {return email;}
    public String getType() {return type;}
    public File getImg() {return img;}
    public int getId() {
        return id;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {this.password = password;}
    public void setEmail(String email) {
        this.email = email;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setImg(File img) {
        this.img = img;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setId(int id) {
        this.id = id;
    }

/*
    protected GenericUserBean(){

    }

    protected GenericUserBean (UserModel userModel){
        this.setSecondName(userModel.getSecondName());
        this.setUsername(userModel.getUsername());
        this.setGender(userModel.getGender());
        this.setPassword(userModel.getPassword());
        this.setEmail(userModel.getEmail());
        this.setId(userModel.getId());
        this.setNumFollower(userModel.getNumFollower());
        this.setNumFollowing(userModel.getNumFollowing());
        this.setType(userModel.getType());
        this.setImg((userModel.getProfileImg()));
    }

    protected GenericUserBean(ClubModel clubModel){
        setEmail(clubModel.getEmail());
        setUsername(clubModel.getUsername());
        setName(clubModel.getClubName());
        setPassword(clubModel.getPassword());
        setType(clubModel.getType());
        setImg(clubModel.getProfileImg());
        setId(clubModel.getId());
        setAddress(clubModel.getAddress());
        setWebsite(clubModel.getWebsite());
        setCity(clubModel.getCity());


    }
    protected GenericUserBean(ClubModel clubModel, CreatedEventList cr){

        setEmail(clubModel.getEmail());
        setUsername(clubModel.getUsername());
        setName(clubModel.getClubName());
        setPassword(clubModel.getPassword());
        setType(clubModel.getType());
        setImg(clubModel.getProfileImg());

        setAddress(clubModel.getAddress());
        setWebsite(clubModel.getWebsite());
        setCity(clubModel.getCity());

        setNumCreatedEvents(cr.getSize());

    }
*/

}
