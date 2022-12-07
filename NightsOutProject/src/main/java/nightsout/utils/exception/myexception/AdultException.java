package nightsout.utils.exception.myexception;

public class AdultException extends Exception {

    public AdultException() {
        super("You must be an adult to register in the app!");
    }
}
