package nightsout.utils.exception;

import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.exception.myexception.DBConnectionFailedException;
import nightsout.utils.exception.myexception.SystemException;

import java.sql.SQLException;

public class ExceptionHandler {

    public static void handleException(Exception e) throws SystemException {

        if (e instanceof SQLException) {
            if (((SQLException) e).getErrorCode() == 0) {
                Trigger.throwDBConnectionFailedException((SQLException) e);
            } else {
                SystemException exception = new SystemException();
                exception.initCause(e);
                throw exception;
            }
        } else if (e instanceof DBConnectionFailedException) {
            MyNotification.createNotification(e);
        } else {
            SystemException exception = new SystemException();
            exception.initCause(e);
            throw exception;
        }
    }
}

