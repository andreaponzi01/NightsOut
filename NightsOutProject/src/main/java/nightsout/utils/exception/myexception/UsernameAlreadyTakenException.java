package nightsout.utils.exception.myexception;

public class UsernameAlreadyTakenException extends Exception {
    public UsernameAlreadyTakenException(String username) {
        super("The username " + username + " is already taken.");
    }
}
