package nightsout.utils.scene;

import nightsout.control.guicontroller.interface1.ViewCommunityGUIController1;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.exception.myexception.SystemException;

public class InitCommunityPage {

    public void setter(ViewCommunityGUIController1 viewCommunityGUIController1, ClubOwnerBean1 clubOwnerBean) throws SystemException {
        viewCommunityGUIController1.setAll(clubOwnerBean);
    }


}
