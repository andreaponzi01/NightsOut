package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ClubOwnerPageGUIController1;
import nightsout.control.guicontroller.interface1.CreateEventReviewGUIController1;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;

import java.sql.SQLException;

public class ReviewPageSetter1 {

    private ReviewPageSetter1() {
        //ignored
    }

    public static void setter( EventBean eventBean, CreateEventReviewGUIController1 createEventReviewGUIController1) throws SQLException {
        createEventReviewGUIController1.setAll(eventBean);
    }
}
