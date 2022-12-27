package nightsout.utils.scene.initPage1;

import nightsout.control.guicontroller.interface1.ClubOwnerCommunityFromCOGUIController1;
import nightsout.control.guicontroller.interface1.ClubOwnerCommunityFromUserGUIController1;
import nightsout.control.guicontroller.interface1.UserPageGUIController1;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.exception.myexception.SystemException;

public class InitCommunityPage {

    private InitCommunityPage() {
        //ignored
    }

    public static void setterUser(ClubOwnerCommunityFromUserGUIController1 clubOwnerCommunityFromUserGUIController1, ClubOwnerBean1 clubOwnerBean) throws SystemException {
        clubOwnerCommunityFromUserGUIController1.setAll(clubOwnerBean);
    }
    public static void setterCO(ClubOwnerCommunityFromCOGUIController1 clubOwnerCommunityFromCOGUIController1, ClubOwnerBean1 clubOwnerBean) throws SystemException {
        clubOwnerCommunityFromCOGUIController1.setAll(clubOwnerBean);
    }

}
