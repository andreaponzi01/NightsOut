package nightsout.utils.exception.myexception;

public class BeforeDateException extends Exception {
    public BeforeDateException() {
        super("You must insert a valid date!");
    }
}
