package nightsout.utils.switchpage.initpage1;

import nightsout.control.appcontroller.ManageReviewAppController;
import nightsout.control.guicontroller.interface1.user.MakeReviewGUIController1;
import nightsout.utils.bean.interface1.EventBean1;

public class ReviewPageSetter1 {

    public void setter(EventBean1 eventBean, ManageReviewAppController manageReviewAppController, MakeReviewGUIController1 makeReviewGUIController1) {
        makeReviewGUIController1.setAll(eventBean, manageReviewAppController);
    }
}
