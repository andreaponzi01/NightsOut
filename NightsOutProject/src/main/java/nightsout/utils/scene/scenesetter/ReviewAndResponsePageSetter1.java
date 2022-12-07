package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ReviewAndResponseGUIController1;
import nightsout.utils.exception.myexception.SystemException;

public class ReviewAndResponsePageSetter1 {

    private ReviewAndResponsePageSetter1() {
        //ignored
    }

    public static void setter(ReviewAndResponseGUIController1 reviewAndResponseGUIController1) throws SystemException {
        reviewAndResponseGUIController1.setAll();
    }



}
