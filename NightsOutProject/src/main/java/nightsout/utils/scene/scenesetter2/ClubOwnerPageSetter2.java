package nightsout.utils.scene.scenesetter2;

import nightsout.control.guicontroller.interface1.ClubOwnerPageGUIController1;
import nightsout.control.guicontroller.interface1.ViewClubOwnerPageFromCOGUIController1;
import nightsout.control.guicontroller.interface1.ViewClubOwnerPageFromUserGUIController1;
import nightsout.control.guicontroller.interface2.ClubOwnerPageGUIController2;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.exception.myexception.SystemException;

public class ClubOwnerPageSetter2 {

    private ClubOwnerPageSetter2() {
        //ignored
    }
    /*
    public static void setterViewFromUser(ClubOwnerBean clubOwnerBean, ViewClubOwnerPageFromUserGUIController1 viewClubOwnerPageFromUserGUIController1) throws SystemException{
        viewClubOwnerPageFromUserGUIController1.setAll(clubOwnerBean);
    }
    public static void setterViewFromCO(ClubOwnerBean clubOwnerBean, ViewClubOwnerPageFromCOGUIController1 viewClubOwnerPageFromCOGUIController1) throws SystemException{
        viewClubOwnerPageFromCOGUIController1.setAll(clubOwnerBean);
    }
     */
    public static void setter(ClubOwnerPageGUIController2 clubOwnerPageGUIController2) throws SystemException {
        clubOwnerPageGUIController2.setAll();
    }
}
