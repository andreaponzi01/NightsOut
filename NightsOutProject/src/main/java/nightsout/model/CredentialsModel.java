package nightsout.model;

import nightsout.utils.bean.CredentialsBean;

public class CredentialsModel {
    private String username;
    private String password;
    private String type;

    public CredentialsModel() {
    }

    public CredentialsModel(CredentialsBean credentialsBean){
        setUsername(credentialsBean.getUsername());
        setPassword(credentialsBean.getPassword());
        setType(credentialsBean.getType());
    }


    public  void setPassword(String password){this.password =password; }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setType(String type) {this.type = type;}

    public String getUsername() {
        return username;
    }
    public  String getPassword(){return this.password;}
    public String getType() {
        return type;
    }

}
