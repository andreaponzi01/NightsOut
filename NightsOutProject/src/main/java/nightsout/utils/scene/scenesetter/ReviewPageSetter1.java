package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ClubOwnerPageGUIController1;
import nightsout.control.guicontroller.interface1.CreateEventReviewGUIController1;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;

public class ReviewPageSetter1 {

    private ReviewPageSetter1() {
        //ignored
    }

    public static void setter(UserBean userBean, EventBean eventBean, CreateEventReviewGUIController1 createEventReviewGUIController1) {
        createEventReviewGUIController1.setAll(eventBean,userBean);
    }
}
