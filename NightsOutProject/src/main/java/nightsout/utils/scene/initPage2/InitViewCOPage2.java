package nightsout.utils.scene.initPage2;

import nightsout.control.guicontroller.interface2.EventParticipantsGUIController2;
import nightsout.control.guicontroller.interface2.ViewCOPageFromUserGUIController2;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.exception.myexception.SystemException;

public class InitViewCOPage2 {

    private InitViewCOPage2() {
        //ignored
    }
    /*
    public static void setterCO(EventBean eventBean, EventParticipantsGUIController2 eventParticipantsGUIController2) throws SystemException {
        eventParticipantsGUIController2.setAll(eventBean);
    }
     */
    public static void setterUser(ClubOwnerBean clubOwnerBean, ViewCOPageFromUserGUIController2 viewCOPageFromUserGUIController2) throws SystemException {
        viewCOPageFromUserGUIController2.setAll(clubOwnerBean);
    }
}
