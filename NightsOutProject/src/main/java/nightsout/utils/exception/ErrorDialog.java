package nightsout.utils.exception;

import nightsout.utils.exception.myexception.SystemException;
import org.json.JSONException;

import java.io.IOException;
import java.sql.SQLException;

public class ErrorDialog {

    private ErrorDialog() {
        // ignored
    }

    private static ErrorDialog instance = null;

    public static ErrorDialog getInstance() {
        if (instance == null) {
            instance = new ErrorDialog();
        }
        return instance;
    }

    public void handleException(Exception e) {
        CreateNotification createNotification = new CreateNotification();
        if (e instanceof SQLException) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            ErrorDialog.getInstance().handleException(exception);
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

