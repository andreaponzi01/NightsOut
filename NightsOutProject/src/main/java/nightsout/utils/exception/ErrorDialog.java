package nightsout.utils.exception;

import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.factory.Factory;
import nightsout.utils.factory.MyDialogBox;
import org.json.JSONException;

import java.io.IOException;
import java.sql.SQLException;

public class ErrorDialog {

    private ErrorDialog() {
        // ignored
    }

    private static ErrorDialog instance = null;
    private Factory factory = new Factory();

    public static ErrorDialog getInstance() {
        if (instance == null) {
            instance = new ErrorDialog();
        }
        return instance;
    }

    public void handleException(Exception e) {
        if (e instanceof SQLException) {
            SystemException exception = new SystemException();
            exception.initCause(e);
            ErrorDialog.getInstance().handleException(exception);
        } else if (e instanceof IOException || e instanceof JSONException || e instanceof ClassNotFoundException) {
            // Eccezioni gestite solo parzialmente
            SystemException exception = new SystemException();
            exception.initCause(e);
            MyDialogBox myDialogBox = factory.createMyDialogBox(exception);
            myDialogBox.useMyDialogBox(exception);
        } else {
            MyDialogBox myDialogBox = factory.createMyDialogBox(e);
            myDialogBox.useMyDialogBox(e);
        }
    }
}

