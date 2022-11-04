package nightsout.utils.scenes.interface1;

import nightsout.control.guicontroller.interface1.ClubOwnerPageGUIController1;
import nightsout.utils.bean.ClubOwnerBean;

public class ClubOwnerPageSetter1 {

    private ClubOwnerPageSetter1() {
        //ignored
    }

    public static void setter(ClubOwnerBean clubOwnerBean, ClubOwnerPageGUIController1 clubOwnerPageGUIController1) {
        clubOwnerPageGUIController1.setAll(clubOwnerBean);
    }
}
