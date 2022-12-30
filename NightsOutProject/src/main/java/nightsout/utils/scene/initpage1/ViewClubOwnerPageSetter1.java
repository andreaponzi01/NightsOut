package nightsout.utils.scene.initpage1;

import nightsout.control.guicontroller.interface1.clubowner.ClubOwnerPageFromCOGUIController1;
import nightsout.control.guicontroller.interface1.user.ClubOwnerPageFromUserGUIController1;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.exception.myexception.SystemException;

public class ViewClubOwnerPageSetter1 {

    private ViewClubOwnerPageSetter1() {
        //ignored
    }
    public static void setterViewFromUser(ClubOwnerBean1 clubOwnerBean, ClubOwnerPageFromUserGUIController1 clubOwnerPageFromUserGUIController1) throws SystemException{
        clubOwnerPageFromUserGUIController1.setAll(clubOwnerBean);
    }
    public static void setterViewFromCO(ClubOwnerBean1 clubOwnerBean, ClubOwnerPageFromCOGUIController1 clubOwnerPageFromCOGUIController1) throws SystemException{
        clubOwnerPageFromCOGUIController1.setAll(clubOwnerBean);
    }

}
