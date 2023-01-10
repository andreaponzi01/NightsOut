package nightsout.utils.scene.initpage2;

import nightsout.control.guicontroller.interface2.ViewClubOwnerPageGUIController2;
import nightsout.utils.bean.interface2.ClubOwnerBean2;
import nightsout.utils.exception.myexception.SystemException;

public class InitViewCOPage2 {

    private InitViewCOPage2() {
        //ignored
    }

    public static void setter(ClubOwnerBean2 clubOwnerBean, ViewClubOwnerPageGUIController2 viewClubOwnerPageGUIController2) throws SystemException {
        viewClubOwnerPageGUIController2.setAll(clubOwnerBean);
    }
}
