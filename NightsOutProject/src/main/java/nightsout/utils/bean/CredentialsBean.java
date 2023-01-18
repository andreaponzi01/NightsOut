package nightsout.utils.bean;

import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.PasswordNotCompliantException;

public class CredentialsBean {

    private Trigger trigger = new Trigger();

    public CredentialsBean() {
    }

    public CredentialsBean(String username, String password, String type) {

        this.username = username;
        this.password = password;
        this.type = type;
    }

    protected String username;
    protected String password;
    protected String type;

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getType() {
        return type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) throws EmptyInputException, PasswordNotCompliantException {
        if (password.equals("")) {
            trigger.throwEmptyInputException("Password");
        } else if (password.length() < 8) {
            trigger.throwPasswordNotCompliantException();
        } else {
            this.password = password;
        }
    }

    public void setType(String type) {
        this.type = type;
    }
}
