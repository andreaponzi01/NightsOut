package nightsout.utils.scenes.interface1;

import nightsout.control.guicontroller.interface1.SubscriptionVipPageGUIController1;
import nightsout.control.guicontroller.interface1.SubscriptionedVipPageGUIController1;
import nightsout.utils.bean.UserBean;

public class SubscriptionPageSetter1 {
    private SubscriptionPageSetter1() {
        //ignored
    }

    public static void setter1(UserBean userBean, SubscriptionVipPageGUIController1 subscriptionPageGUIController1) {
        subscriptionPageGUIController1.setAll(userBean);
    }

    public static void setter2(UserBean userBean, SubscriptionedVipPageGUIController1 subscriptionedPageGUIController1) {
        subscriptionedPageGUIController1.setAll(userBean);
    }
}
