package nightsout.model;

import java.io.File;

public abstract class ProfileModel {

    /*
        Questo è il Model del profilo, cioè contiene le informazioni IN COMUNE per gli Users
        e i Club Owners.
     */
    protected int id ;
    protected File profileImg;
    protected String email;
    protected String username;

    protected ProfileModel() {

    }

    public String getEmail() {
        return email;
    }

    protected ProfileModel(String username) {
        this.username = username;
    }

    protected ProfileModel(String username, String email, int id, File profileImg) {
        this.email = email;
        this.id = id;
        this.profileImg = profileImg;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public File getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(File profileImg) {
        this.profileImg = profileImg;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
