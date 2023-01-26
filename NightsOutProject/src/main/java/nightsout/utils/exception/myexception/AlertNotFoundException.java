package nightsout.utils.exception.myexception;

public class AlertNotFoundException extends Exception {

    public AlertNotFoundException() {
        super("Error: can't properly view the alert box. Functionality not available.");
    }
}
