package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ClubOwnerPageGUIController1;
import nightsout.control.guicontroller.interface1.ViewClubOwnerPageFromCOGUIController1;
import nightsout.control.guicontroller.interface1.ViewClubOwnerPageFromUserGUIController1;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.exception.myexception.SystemException;

public class ClubOwnerPageSetter1 {

    private ClubOwnerPageSetter1() {
        //ignored
    }
    public static void setterViewFromUser(ClubOwnerBean1 clubOwnerBean1, ViewClubOwnerPageFromUserGUIController1 viewClubOwnerPageFromUserGUIController1) throws SystemException{
        viewClubOwnerPageFromUserGUIController1.setAll(clubOwnerBean1);
    }
    public static void setterViewFromCO(ClubOwnerBean1 clubOwnerBean1, ViewClubOwnerPageFromCOGUIController1 viewClubOwnerPageFromCOGUIController1) throws SystemException{
        viewClubOwnerPageFromCOGUIController1.setAll(clubOwnerBean1);
    }

    public static void setter(ClubOwnerPageGUIController1 clubOwnerPageGUIController1) throws SystemException {
        clubOwnerPageGUIController1.setAll();
    }
}
