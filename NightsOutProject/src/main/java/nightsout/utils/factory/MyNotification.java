package nightsout.utils.factory;

import org.controlsfx.control.Notifications;

public class MyNotification implements MyDialogBox {

    private void notify(String title, Notifications notification, String message){
        notification.title(title);
        notification.text(message);
        notification.show();
    }

    @Override
    public void useMyDialogBox(Exception e) {
        Notifications notification = Notifications.create();
        notify("Warning", notification, e.getMessage());
    }
}
