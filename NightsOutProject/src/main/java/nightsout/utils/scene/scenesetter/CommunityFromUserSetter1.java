package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ClubOwnerCommunityFromUserGUIController1;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.exception.myexception.SystemException;

public class CommunityFromUserSetter1 {

    public static void setter(ClubOwnerCommunityFromUserGUIController1 clubOwnerCommunityFromUserGUIController1, ClubOwnerBean clubOwnerBean) throws SystemException {
        clubOwnerCommunityFromUserGUIController1.setAll(clubOwnerBean);
    }
}
