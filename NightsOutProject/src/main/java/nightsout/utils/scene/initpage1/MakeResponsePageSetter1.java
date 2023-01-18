package nightsout.utils.scene.initpage1;

import nightsout.control.guicontroller.interface1.clubowner.MakeResponseGUIController1;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.SystemException;

public class MakeResponsePageSetter1 {

    public void setter(UserBean1 userBean, ReviewBean reviewBean, MakeResponseGUIController1 makeResponseGUIController1) throws SystemException {
        makeResponseGUIController1.setAll(userBean,reviewBean);
    }
}
