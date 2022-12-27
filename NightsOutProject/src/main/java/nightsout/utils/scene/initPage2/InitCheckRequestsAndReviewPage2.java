package nightsout.utils.scene.initPage2;

import nightsout.control.guicontroller.interface2.CheckRequestsAndReviewGUIController2;
import nightsout.utils.exception.myexception.SystemException;

public class InitCheckRequestsAndReviewPage2 {

    private InitCheckRequestsAndReviewPage2() {
        //ignored
    }

    public static void setter(CheckRequestsAndReviewGUIController2 checkRequestsAndReviewGUIController2) throws SystemException {
        checkRequestsAndReviewGUIController2.setAll();
    }
}
