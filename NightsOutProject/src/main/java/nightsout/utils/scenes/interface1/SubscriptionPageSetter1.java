package nightsout.utils.scenes.interface1;

import nightsout.control.guicontroller.interface1.SubscriptionPageGUIController1;
import nightsout.utils.bean.UserBean;

public class SubscriptionPageSetter1 {
    private SubscriptionPageSetter1() {
        //ignored
    }

    public static void setter(UserBean userBean, SubscriptionPageGUIController1 subscriptionPageGUIController1) {
        subscriptionPageGUIController1.setAll(userBean);
    }
}
