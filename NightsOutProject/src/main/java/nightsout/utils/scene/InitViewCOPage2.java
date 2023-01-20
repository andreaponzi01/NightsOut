package nightsout.utils.scene;

import nightsout.control.guicontroller.interface2.ViewClubOwnerPageGUIController2;
import nightsout.utils.bean.interface2.ClubOwnerBean2;
import nightsout.utils.exception.myexception.SystemException;

public class InitViewCOPage2 {

    public void setter(ClubOwnerBean2 clubOwnerBean, ViewClubOwnerPageGUIController2 viewClubOwnerPageGUIController2) throws SystemException {
        viewClubOwnerPageGUIController2.setAll(clubOwnerBean);
    }
}
