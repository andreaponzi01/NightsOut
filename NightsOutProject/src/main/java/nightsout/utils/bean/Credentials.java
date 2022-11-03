package nightsout.utils.bean;

public class Credentials {
    private String username;
    private String password;
    private String type;

    public Credentials(String username, String password, String type){
        setUsername(username);
        setPassword(password);
        setType(type);
    }

    public Credentials(String username){
        this.username = username;

        // Aggiunti 3-nov
        this.password = null;
        this.type = null;
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