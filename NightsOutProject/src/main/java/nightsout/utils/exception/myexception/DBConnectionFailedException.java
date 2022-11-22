package nightsout.utils.exception.myexception;

public class DBConnectionFailedException extends Exception {

    public DBConnectionFailedException() {
        super("Connessione al Database fallita");
    }
}
