package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ClubOwnerPageGUIController1;
import nightsout.control.guicontroller.interface1.ViewClubOwnerPageGUIController1;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.exception.myexception.SystemException;

public class ClubOwnerPageSetter1 {

    private ClubOwnerPageSetter1() {
        //ignored
    }
    public static void setterItem(ClubOwnerBean clubOwnerBean, ViewClubOwnerPageGUIController1 viewClubOwnerPageGUIController1) {
        viewClubOwnerPageGUIController1.setAll(clubOwnerBean);
    }

    public static void setter(ClubOwnerPageGUIController1 clubOwnerPageGUIController1) throws SystemException {
        clubOwnerPageGUIController1.setAll();
    }
}
