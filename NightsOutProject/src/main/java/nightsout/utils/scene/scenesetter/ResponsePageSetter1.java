package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.CreateEventReviewGUIController1;
import nightsout.control.guicontroller.interface1.EventReviewsClubOwnerGUIController1;
import nightsout.control.guicontroller.interface1.MakeResponseGUIController1;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.UserBean;

import java.sql.SQLException;

public class ResponsePageSetter1 {

    private ResponsePageSetter1() {
        //ignored
    }

    public static void setter(EventReviewsClubOwnerGUIController1 eventReviewsClubOwnerGUIController1) throws SQLException {
        eventReviewsClubOwnerGUIController1.setAll();
    }

    public static void setter2(UserBean userBean, ReviewBean reviewBean, MakeResponseGUIController1 makeResponseGUIController1) throws SQLException {
        makeResponseGUIController1.setAll(userBean,reviewBean);
    }
}
