package nightsout.utils.exception.myexception;

public class SystemException extends Exception{

    public SystemException() {
        super("Ops... An error occurred.");
    }

    public SystemException(String message) {
        super("Ops... An error occurred.\n" + message);
    }
}
