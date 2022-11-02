package nightsout.utils.exception;

import nightsout.utils.exception.myexception.*;

public class Trigger {

    private Trigger() {
        //ignored
    }

    public static void throwWrongPassword() throws WrongPasswordException {
        throw new WrongPasswordException();
    }
}