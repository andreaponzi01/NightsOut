package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.CreateEventReviewGUIController1;
import nightsout.utils.bean.EventBean;

public class ReviewPageSetter1 {

    private ReviewPageSetter1() {
        //ignored
    }

    public static void setter( EventBean eventBean, CreateEventReviewGUIController1 createEventReviewGUIController1) {
        createEventReviewGUIController1.setAll(eventBean);
    }
}
