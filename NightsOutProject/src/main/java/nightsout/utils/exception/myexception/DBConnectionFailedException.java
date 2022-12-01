package nightsout.utils.exception.myexception;

public class DBConnectionFailedException extends SystemException {

    public DBConnectionFailedException() {
        super("Connessione al Database fallita");
    }
}
