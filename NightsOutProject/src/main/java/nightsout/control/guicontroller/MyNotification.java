package nightsout.control.guicontroller;

import org.controlsfx.control.Notifications;

    public class MyNotification {

        private MyNotification(){
            //ignored
        }
        private static void notify(String title, Notifications notification, String message){
            notification.title(title);
            notification.text(message);
            notification.show();
        }

        public static void createNotification(Exception e){
            Notifications notifications = Notifications.create();
            notify("Attenzione", notifications, e.getMessage());
        }

}
