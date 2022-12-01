package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.SubscriptionVipPageGUIController1;
import nightsout.control.guicontroller.interface1.SubscriptionedVipPageGUIController1;
import nightsout.utils.bean.UserBean;

import java.sql.SQLException;

public class SubscriptionPageSetter1 {
    private SubscriptionPageSetter1() {
        //ignored
    }

    public static void setter1(SubscriptionVipPageGUIController1 subscriptionPageGUIController1) throws SQLException {
        subscriptionPageGUIController1.setAll();
    }

    public static void setter2( SubscriptionedVipPageGUIController1 subscriptionedPageGUIController1) throws SQLException {
        subscriptionedPageGUIController1.setAll();
    }
}
