package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ClubOwnerCommunityFromCOGUIController1;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.exception.myexception.SystemException;

public class CommunityFromCOSetter1 {

    public static void setter(ClubOwnerCommunityFromCOGUIController1 clubOwnerCommunityFromCOGUIController1, ClubOwnerBean1 clubOwnerBean1) throws SystemException {
        clubOwnerCommunityFromCOGUIController1.setAll(clubOwnerBean1);
    }
}
