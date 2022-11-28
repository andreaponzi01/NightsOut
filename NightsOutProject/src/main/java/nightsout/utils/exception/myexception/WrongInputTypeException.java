package nightsout.utils.exception.myexception;

public class WrongInputTypeException extends Exception {

    public WrongInputTypeException(String field) {
        super("Insert a proper input on field " + field);
    }
}
