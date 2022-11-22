package nightsout.utils.exception;

import nightsout.utils.exception.myexception.*;

/*
    È la classe che si occupa di lanciare (throw) effettivamente una delle nuove eccezioni definite.
 */
public class Trigger {

    private Trigger() {
        //ignored
    }

    public static void emptyField(String field) throws EmptyInputException {
        throw new EmptyInputException(field);
    }
    public static void throwWrongPassword() throws WrongCredentialsException {
        throw new WrongCredentialsException();
    }

    public static void throwDBConnectionFailedException() throws DBConnectionFailedException {
        throw new DBConnectionFailedException();
    }
}