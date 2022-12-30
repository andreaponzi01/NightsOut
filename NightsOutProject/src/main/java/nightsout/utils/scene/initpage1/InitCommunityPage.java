package nightsout.utils.scene.initpage1;

import nightsout.control.guicontroller.interface1.clubowner.CommunityFromCOGUIController1;
import nightsout.control.guicontroller.interface1.user.CommunityFromUserGUIController1;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.exception.myexception.SystemException;

public class InitCommunityPage {

    private InitCommunityPage() {
        //ignored
    }

    public static void setterUser(CommunityFromUserGUIController1 communityFromUserGUIController1, ClubOwnerBean1 clubOwnerBean) throws SystemException {
        communityFromUserGUIController1.setAll(clubOwnerBean);
    }
    public static void setterCO(CommunityFromCOGUIController1 communityFromCOGUIController1, ClubOwnerBean1 clubOwnerBean) throws SystemException {
        communityFromCOGUIController1.setAll(clubOwnerBean);
    }

}
