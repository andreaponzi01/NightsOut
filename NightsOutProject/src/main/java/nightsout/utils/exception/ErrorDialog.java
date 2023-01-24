package nightsout.utils.exception;

import nightsout.utils.factory.Factory;
import nightsout.utils.factory.MyDialogBox;

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
        // ErrorDialog Pattern + Factory Pattern
        MyDialogBox myDialogBox = factory.createMyDialogBox(e);
        myDialogBox.useMyDialogBox(e.getMessage());
        e.printStackTrace();
    }
}

