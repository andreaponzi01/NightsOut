package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.EndedBookedEventsGUIController1;
import nightsout.control.guicontroller.interface1.ReviewAndResponseGUIController1;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;

import java.sql.SQLException;

public class ReviewAndResponsePageSetter1 {

    private ReviewAndResponsePageSetter1() {
        //ignored
    }

    public static void setter(ClubOwnerBean clubOwnerBean, ReviewAndResponseGUIController1 reviewAndResponseGUIController1) throws SQLException {
        reviewAndResponseGUIController1.setAll(clubOwnerBean);
    }



}
