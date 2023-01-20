package nightsout.utils.scene;

import nightsout.control.guicontroller.interface1.ViewClubOwnerPageGUIController1;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.exception.myexception.SystemException;

public class ViewClubOwnerPageSetter1 {

    public void setterView(ClubOwnerBean1 clubOwnerBean, ViewClubOwnerPageGUIController1 viewClubOwnerPageGUIController1) throws SystemException{
        viewClubOwnerPageGUIController1.setAll(clubOwnerBean);
    }

}
