package nightsout.utils.scene.initpage1;

import nightsout.control.guicontroller.interface1.user.MakeReviewGUIController1;
import nightsout.utils.bean.interface1.EventBean1;

public class ReviewPageSetter1 {

    private ReviewPageSetter1() {
        //ignored
    }

    public static void setter(EventBean1 eventBean, MakeReviewGUIController1 makeReviewGUIController1) {
        makeReviewGUIController1.setAll(eventBean);
    }
}
