package nightsout.utils.exception;

import org.controlsfx.control.Notifications;

public class CreateNotification {

        CreateNotification(){
            //ignored
        }
        private void notify(String title, Notifications notification, String message){
            notification.title(title);
            notification.text(message);
            notification.show();
        }

        public void createNotification(Exception e){
            Notifications notification = Notifications.create();
            notify("Warning", notification, e.getMessage());
        }

}
