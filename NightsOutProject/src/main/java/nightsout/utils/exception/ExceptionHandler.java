package nightsout.utils.exception;

import nightsout.utils.exception.myexception.SystemException;
import org.json.JSONException;

import java.io.IOException;
import java.sql.SQLException;

public class ExceptionHandler {

    private ExceptionHandler() {
        // ignored
    }

    public static void handleException(Exception e) {

        if (e instanceof SQLException || e instanceof IOException || e instanceof JSONException) {
                SystemException exception = new SystemException();
                exception.initCause(e);
                CreateNotification.createNotification(exception);
        } else {
            CreateNotification.createNotification(e);
        }
    }
}

