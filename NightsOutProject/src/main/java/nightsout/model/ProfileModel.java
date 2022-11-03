package nightsout.model;

import nightsout.utils.bean.Credentials;

import java.io.File;

public abstract class ProfileModel {
/*
    Questo è il Model del profilo, cioè contiene le informazioni IN COMUNE per gli Users
    e i Club Owners. Inoltre, contiene le CREDENZIALI ottenute successivamente a un login
    effettuato con successo.
 */
    private int id ;
    private File profileImg;
    private Credentials cred;

    public String getEmail() {
        return email;
    }

    private String email;

    protected ProfileModel(String username) {
        this.cred = new Credentials(username);
    }

    protected ProfileModel(Credentials cred, File profileImg) {
        setProfileImg(profileImg);
        setCredentials(cred);
    }
    protected ProfileModel (int id, Credentials cred, File profileImg){
        setId(id);
        setCredentials(cred);
        setProfileImg(profileImg);
    }

    // Getter
    public String getUsername() {
        return this.cred.getUsername();
    }
    public  String getPassword(){return this.cred.getPassword();}
    public String getType() {return this.cred.getType();}
    public int getId() {
        return id;
    }
    public File getProfileImg() {
        return profileImg;
    }
    public Credentials getCredentials() {
        return cred;
    }

    // Setter
    public void setCredentials(Credentials cred) {this.cred = cred;}
    public void setId(int id) {this.id = id;}
    public void setProfileImg(File profileImg) {this.profileImg= profileImg ;}
    public void setEmail(String email) { this.email = email; }

}
