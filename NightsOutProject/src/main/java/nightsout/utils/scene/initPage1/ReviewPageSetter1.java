package nightsout.utils.scene.initPage1;

import nightsout.control.guicontroller.interface1.CreateEventReviewGUIController1;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.interface1.EventBean1;

public class ReviewPageSetter1 {

    private ReviewPageSetter1() {
        //ignored
    }

    public static void setter(EventBean1 eventBean, CreateEventReviewGUIController1 createEventReviewGUIController1) {
        createEventReviewGUIController1.setAll(eventBean);
    }
}
