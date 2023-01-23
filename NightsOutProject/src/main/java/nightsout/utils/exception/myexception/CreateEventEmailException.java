package nightsout.utils.exception.myexception;

public class CreateEventEmailException extends Exception {

    public CreateEventEmailException() {
        super("Error: Failed to send the email during event creation.");
    }
}
