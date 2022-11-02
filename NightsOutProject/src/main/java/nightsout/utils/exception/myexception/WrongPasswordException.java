package nightsout.utils.exception.myexception;

public class WrongPasswordException extends Exception {
    public WrongPasswordException( ){
        super("Username o password errati");
    }
}
