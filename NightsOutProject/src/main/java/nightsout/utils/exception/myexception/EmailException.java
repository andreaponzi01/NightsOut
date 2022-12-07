package nightsout.utils.exception.myexception;

public class EmailException extends SystemException {
    public EmailException() {
        super("Can't send the email.");
    }
}
