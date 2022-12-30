package nightsout.utils.exception;

import nightsout.utils.exception.myexception.SystemException;

import java.io.IOException;
import java.sql.SQLException;

public class ExceptionHandler {

    private ExceptionHandler() {
        // ignored
    }

    public static void handleException(Exception e) throws SystemException {

        if (e instanceof SQLException) {
            if (((SQLException) e).getErrorCode() == 0) {
                Trigger.throwDBConnectionFailedException((SQLException) e);
            } else {
                SystemException exception = new SystemException();
                exception.initCause(e);
                throw exception;
            }
        } else if (e instanceof IOException) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            CreateNotification.createNotification(exception);
        } else {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }
}

