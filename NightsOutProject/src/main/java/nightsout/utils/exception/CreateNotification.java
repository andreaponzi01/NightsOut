package nightsout.utils.exception;

import org.controlsfx.control.Notifications;

public class CreateNotification {

        private CreateNotification(){
            //ignored
        }
        private static void notify(String title, Notifications notification, String message){
            notification.title(title);
            notification.text(message);
            notification.show();
        }

        public static void createNotification(Exception e){
            Notifications notification = Notifications.create();
            notify("Warning", notification, e.getMessage());
        }

}
