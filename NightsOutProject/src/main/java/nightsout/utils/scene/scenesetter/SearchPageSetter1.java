package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.SearchPageGUIController1;
import nightsout.utils.bean.UserBean;

import java.sql.SQLException;

public class SearchPageSetter1 {

    private SearchPageSetter1() {
        //ignored
    }

    public static void setter( SearchPageGUIController1 searchPageGUIController1) throws SQLException {
        searchPageGUIController1.setAll();
    }
}
