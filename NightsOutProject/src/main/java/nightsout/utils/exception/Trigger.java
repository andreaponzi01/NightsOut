package nightsout.utils.exception;

import nightsout.utils.exception.myexception.*;

import javax.mail.MessagingException;
import java.sql.SQLException;

/*
    È la classe che si occupa di lanciare (throw) effettivamente una delle nuove eccezioni definite.
 */
public class Trigger {

    private Trigger() {
        //ignored
    }

    public static void throwEmptyInputException(String field) throws EmptyInputException {
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

    public static void throwBeforeDateException() throws BeforeDateException {
        throw new BeforeDateException();
    }

    public static void throwEmailException(MessagingException e) throws EmailException {
        EmailException exception = new EmailException();
        exception.initCause(e);
        throw exception;
    }

    public static void throwExceededRangeException(String field) throws WrongInputRangeException {
        throw new WrongInputRangeException(field);
    }

    public static void throwAdultException() throws AdultException {
        throw new AdultException();
    }

    public static void throwUsernameAlreadyTakenException(String username) throws UsernameAlreadyTakenException {
        throw new UsernameAlreadyTakenException(username);
    }

    public static void throwPasswordNotCompliantException() throws PasswordNotCompliantException {
        throw new PasswordNotCompliantException();
    }
}