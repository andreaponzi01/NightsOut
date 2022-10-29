package nightsout.utils.bean;

public abstract class LoginBean {
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
}
