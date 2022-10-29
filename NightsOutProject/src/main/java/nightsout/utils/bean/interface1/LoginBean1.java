package nightsout.utils.bean.interface1;

import nightsout.utils.bean.LoginBean;

public class LoginBean1 extends LoginBean {
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setType(String type) { this.type = type; }

    public LoginBean1(String username,String password, String type) {
        this.setUsername(username);
        this.setPassword(password);
        this.setType(type);
    }
}
