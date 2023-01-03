package nightsout.utils.scene.initpage2;

import nightsout.control.guicontroller.interface2.clubowner.ViewCOPageFromCOGUIController2;
import nightsout.control.guicontroller.interface2.user.ViewCOPageFromUserGUIController2;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.interface2.ClubOwnerBean2;
import nightsout.utils.exception.myexception.SystemException;

public class InitViewCOPage2 {

    private InitViewCOPage2() {
        //ignored
    }

    public static void setterCO(ClubOwnerBean2 clubOwnerBean, ViewCOPageFromCOGUIController2 viewCOPageFromCOGUIController2) throws SystemException {
        viewCOPageFromCOGUIController2.setAll(clubOwnerBean);
    }

    public static void setterUser(ClubOwnerBean clubOwnerBean, ViewCOPageFromUserGUIController2 viewCOPageFromUserGUIController2) throws SystemException {
        viewCOPageFromUserGUIController2.setAll(clubOwnerBean);
    }
}
