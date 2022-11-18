package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.ClubOwnerPageGUIController1;
import nightsout.utils.bean.ClubOwnerBean;

import java.sql.SQLException;

public class ClubOwnerPageSetter1 {

    private ClubOwnerPageSetter1() {
        //ignored
    }

    public static void setter(ClubOwnerBean clubOwnerBean, ClubOwnerPageGUIController1 clubOwnerPageGUIController1) throws SQLException {
        clubOwnerPageGUIController1.setAll(clubOwnerBean);
    }
}
