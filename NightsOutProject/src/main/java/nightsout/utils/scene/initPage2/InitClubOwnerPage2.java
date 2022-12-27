package nightsout.utils.scene.initPage2;

import nightsout.control.guicontroller.interface2.ClubOwnerPageGUIController2;
import nightsout.utils.exception.myexception.SystemException;

public class InitClubOwnerPage2 {

    private InitClubOwnerPage2() {
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
