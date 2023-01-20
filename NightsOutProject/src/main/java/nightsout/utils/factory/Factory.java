package nightsout.utils.factory;

import nightsout.utils.exception.myexception.SystemException;

public class Factory {

    public MyDialogBox createMyDialogBox(Exception e) {
        if (e instanceof SystemException) {
            return (new MyAlert());
        } else {
            return (new MyNotification());
        }
    }
}
