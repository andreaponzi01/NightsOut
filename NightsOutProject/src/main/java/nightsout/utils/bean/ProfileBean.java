package nightsout.utils.bean;

import nightsout.control.appcontroller.RegisterAppController;
import nightsout.utils.CheckEmail;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.EmailNotValidException;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.exception.myexception.UsernameAlreadyTakenException;

import java.io.File;

public abstract class ProfileBean implements GenericBean {

    protected Trigger trigger = new Trigger();

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
        CheckEmail checkEmail = new CheckEmail();
        boolean correctFormat = checkEmail.validate(email);
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

        RegisterAppController controller = new RegisterAppController();
        if (username.equals("")) {
            trigger.throwEmptyInputException("Username");
        } else if (controller.usernameAlreadyTaken(username)) {
            trigger.throwUsernameAlreadyTakenException(username);
        } else {
            this.username = username;
        }
    }
    public void setId(int id) {
        this.id = id;
    }

}
