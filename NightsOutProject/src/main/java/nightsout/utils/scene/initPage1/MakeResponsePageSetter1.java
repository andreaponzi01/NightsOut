package nightsout.utils.scene.initPage1;

import nightsout.control.guicontroller.interface1.MakeResponseGUIController1;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.SystemException;

public class MakeResponsePageSetter1 {

    private MakeResponsePageSetter1() {
        //ignored
    }

    public static void setter(UserBean1 userBean, ReviewBean reviewBean, MakeResponseGUIController1 makeResponseGUIController1) throws SystemException {
        makeResponseGUIController1.setAll(userBean,reviewBean);
    }
}
