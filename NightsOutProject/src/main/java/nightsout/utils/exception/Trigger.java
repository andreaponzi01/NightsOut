package nightsout.utils.exception;

import nightsout.utils.exception.myexception.*;

import javax.mail.MessagingException;
import java.sql.SQLException;

/*
    È la classe che si occupa di lanciare (throw) effettivamente una delle nuove eccezioni definite.
 */
public class Trigger {


    public void throwEmptyInputException(String field) throws EmptyInputException {
        throw new EmptyInputException(field);
    }
    public void throwWrongCredentials() throws WrongCredentialsException {
        throw new WrongCredentialsException();
    }

    public void throwDBConnectionFailedException(SQLException e) throws DBConnectionFailedException {
        DBConnectionFailedException exception = new DBConnectionFailedException();
        exception.initCause(e);
        throw exception;
    }

    public void throwWrongInputTypeException(NumberFormatException e, String field) throws WrongInputTypeException {
        WrongInputTypeException exception = new WrongInputTypeException(field);
        exception.initCause(e);
        throw exception;
    }

    public void throwBeforeDateException() throws BeforeDateException {
        throw new BeforeDateException();
    }

    public void throwExceededRangeException(String field) throws WrongInputRangeException {
        throw new WrongInputRangeException(field);
    }

    public void throwAdultException() throws AdultException {
        throw new AdultException();
    }

    public void throwUsernameAlreadyTakenException(String username) throws UsernameAlreadyTakenException {
        throw new UsernameAlreadyTakenException(username);
    }

    public void throwPasswordNotCompliantException() throws PasswordNotCompliantException {
        throw new PasswordNotCompliantException();
    }

    public void throwGenderException() throws GenderException {
        throw new GenderException();
    }
    public void throwEmailException(MessagingException e) throws EmailException {
        EmailException exception = new EmailException();
        exception.initCause(e);
        throw exception;
    }

    public void throwCreateEventEmailException(EmailException e) throws CreateEventEmailException {
        CreateEventEmailException exception = new CreateEventEmailException();
        exception.initCause(e.getCause());
        throw exception;
    }
}