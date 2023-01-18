package nightsout.utils.exception;

import nightsout.utils.exception.myexception.SystemException;
import org.json.JSONException;

import java.io.IOException;
import java.sql.SQLException;

public class ExceptionHandler {

    private ExceptionHandler() {
        // ignored
    }

    private static ExceptionHandler instance = null;

    public static ExceptionHandler getInstance() {
        if (instance == null) {
            instance = new ExceptionHandler();
        }
        return instance;
    }

    public void handleException(Exception e) {
        CreateNotification createNotification = new CreateNotification();
        if (e instanceof SQLException) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            ExceptionHandler.getInstance().handleException(exception);
        } else if (e instanceof IOException || e instanceof JSONException || e instanceof ClassNotFoundException) {

            // Eccezioni gestite solo parzialmente
            SystemException exception = new SystemException();
            exception.initCause(e);
            createNotification.createNotification(exception);
        }else {
            createNotification.createNotification(e);
        }
    }
}

