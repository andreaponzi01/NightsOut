package nightsout.utils.exception.myexception;

public class WrongInputRangeException extends Exception {

    public WrongInputRangeException(String field) {
        super("Input in field " + field + " not in range.");
    }
}
