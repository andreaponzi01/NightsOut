package nightsout.utils.factory;

import org.controlsfx.control.Notifications;

public class MyNotification implements MyDialogBox {

    private void notify(String title, Notifications notification, String message){
        notification.title(title);
        notification.text(message);
        notification.show();
    }

    @Override
    public void useMyDialogBox(String message) {
        Notifications notification = Notifications.create();
        notify("Warning", notification, message);
    }
}
