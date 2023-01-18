package nightsout.utils.exception.myexception;

public class SystemException extends Exception{

    public SystemException() {
        super("A technical error occurred.");
    }

    public SystemException(String message) {
        super("A technical error occurred.\n" + message);
    }
}
