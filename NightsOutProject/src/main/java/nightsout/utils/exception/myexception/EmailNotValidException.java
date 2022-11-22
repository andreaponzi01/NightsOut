package nightsout.utils.exception.myexception;

public class EmailNotValidException extends Exception {

    public EmailNotValidException(String email) {
        super("The email " + email + " inserted is not valid!");
    }
}
