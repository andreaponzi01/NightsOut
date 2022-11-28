package nightsout.utils.exception;

import nightsout.utils.exception.myexception.*;

import java.sql.SQLException;

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
    public static void throwWrongCredentials() throws WrongCredentialsException {
        throw new WrongCredentialsException();
    }

    public static void throwDBConnectionFailedException(SQLException e) throws DBConnectionFailedException {
        DBConnectionFailedException exception = new DBConnectionFailedException();
        exception.initCause(e);
        throw exception;
    }

    public static void throwWrongInputTypeException(NumberFormatException e, String field) throws WrongInputTypeException {
        WrongInputTypeException exception = new WrongInputTypeException(field);
        exception.initCause(e);
        throw exception;
    }
}