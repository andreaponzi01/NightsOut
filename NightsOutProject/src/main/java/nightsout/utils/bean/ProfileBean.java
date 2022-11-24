package nightsout.utils.bean;

import nightsout.utils.CheckEmail;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.EmailNotValidException;
import nightsout.utils.exception.myexception.EmptyInputException;

import java.io.File;

public abstract class ProfileBean implements GenericBean {

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

    public void setEmailException(String email) throws EmptyInputException, EmailNotValidException {
        if(email.isEmpty()) {
            Trigger.emptyField("email");
        }
        boolean correctFormat = CheckEmail.validate(email);
        if(correctFormat){this.email = email;}
        else{
            throw new EmailNotValidException(email);
        }
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

}
