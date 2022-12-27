package nightsout.utils.scene.initPage1;

import nightsout.control.guicontroller.interface1.ViewClubOwnerPageFromCOGUIController1;
import nightsout.control.guicontroller.interface1.ViewClubOwnerPageFromUserGUIController1;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.exception.myexception.SystemException;

public class ViewClubOwnerPageSetter1 {

    private ViewClubOwnerPageSetter1() {
        //ignored
    }
    public static void setterViewFromUser(ClubOwnerBean1 clubOwnerBean, ViewClubOwnerPageFromUserGUIController1 viewClubOwnerPageFromUserGUIController1) throws SystemException{
        viewClubOwnerPageFromUserGUIController1.setAll(clubOwnerBean);
    }
    public static void setterViewFromCO(ClubOwnerBean1 clubOwnerBean, ViewClubOwnerPageFromCOGUIController1 viewClubOwnerPageFromCOGUIController1) throws SystemException{
        viewClubOwnerPageFromCOGUIController1.setAll(clubOwnerBean);
    }

}
