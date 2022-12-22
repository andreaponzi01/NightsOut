package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ClubOwnerCommunityFromUserGUIController1;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.exception.myexception.SystemException;

public class CommunityFromUserSetter1 {

    public static void setter(ClubOwnerCommunityFromUserGUIController1 clubOwnerCommunityFromUserGUIController1, ClubOwnerBean1 clubOwnerBean1) throws SystemException {
        clubOwnerCommunityFromUserGUIController1.setAll(clubOwnerBean1);
    }
}
