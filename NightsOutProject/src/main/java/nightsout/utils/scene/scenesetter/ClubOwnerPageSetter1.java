package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ClubOwnerPageGUIController1;
import nightsout.control.guicontroller.interface1.ViewClubOwnerPageFromCOGUIController1;
import nightsout.control.guicontroller.interface1.ViewClubOwnerPageFromUserGUIController1;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.exception.myexception.SystemException;

public class ClubOwnerPageSetter1 {

    private ClubOwnerPageSetter1() {
        //ignored
    }
    public static void setterViewFromUser(ClubOwnerBean clubOwnerBean, ViewClubOwnerPageFromUserGUIController1 viewClubOwnerPageFromUserGUIController1) {
        viewClubOwnerPageFromUserGUIController1.setAll(clubOwnerBean);
    }
    public static void setterViewFromCO(ClubOwnerBean clubOwnerBean, ViewClubOwnerPageFromCOGUIController1 viewClubOwnerPageFromCOGUIController1) {
        viewClubOwnerPageFromCOGUIController1.setAll(clubOwnerBean);
    }

    public static void setter(ClubOwnerPageGUIController1 clubOwnerPageGUIController1) throws SystemException {
        clubOwnerPageGUIController1.setAll();
    }
}
