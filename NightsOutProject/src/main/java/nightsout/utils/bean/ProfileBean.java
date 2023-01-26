package nightsout.utils.bean;

import nightsout.utils.engineering.RegistrationEngineering;
import nightsout.utils.engineering.CheckEmailEngineering;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.EmailNotValidException;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.exception.myexception.UsernameAlreadyTakenException;

import java.io.File;

public abstract class ProfileBean implements GenericBean {

    private final Trigger trigger = new Trigger();

    // Attributi comuni a User e ClubOwner
    protected String username;
    // Per gli Users rappresenta il nome (name), mentre per i ClubOwners rappresenta il nome del club (clubName)
    protected String name;
    protected File img;
    protected int id;
    protected String email;

    // Getter
    public String getUsername() {return username;}
    public String getName() {return name;}
    public File getImg() {return img;}
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }

    // Setter
    public void setName(String name) throws EmptyInputException {
        if (name.equals(""))
            trigger.throwEmptyInputException("Name");
        this.name = name;
    }

    public void setEmail(String email) throws EmptyInputException, EmailNotValidException {
        if(email.isEmpty())
            trigger.throwEmptyInputException("email");
        CheckEmailEngineering checkEmailEngineering = new CheckEmailEngineering();
        EmailBean emailBean = new EmailBean();
        emailBean.setEmail(email);
        boolean correctFormat = checkEmailEngineering.validate(emailBean);
        if(correctFormat)
            this.email = email;
        else
            throw new EmailNotValidException(email);
    }

    public void setImg(File img) throws EmptyInputException {
        if (img == null) {
            trigger.throwEmptyInputException("Image");
        } else {
            this.img = img;
        }
    }

    public void setUsername(String username) throws EmptyInputException, UsernameAlreadyTakenException, SystemException {

        RegistrationEngineering engineering = new RegistrationEngineering();
        if (username.equals("")) {
            trigger.throwEmptyInputException("Username");
        } else if (engineering.usernameAlreadyTaken(new UsernameBean(username))) {
            trigger.throwUsernameAlreadyTakenException(username);
        } else {
            this.username = username;
        }
    }
    public void setId(int id) {
        this.id = id;
    }

}
