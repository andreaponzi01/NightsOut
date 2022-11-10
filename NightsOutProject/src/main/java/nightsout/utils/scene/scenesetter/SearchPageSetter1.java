package nightsout.utils.scene.scenesetter;

import nightsout.control.guicontroller.interface1.SearchPageGUIController1;
import nightsout.utils.bean.UserBean;

public class SearchPageSetter1 {

    private SearchPageSetter1() {
        //ignored
    }

    public static void setter(UserBean userBean, SearchPageGUIController1 searchPageGUIController1) {
        searchPageGUIController1.setAll(userBean);
    }

    public static void setter2(UserBean userBean, String oldInput, SearchPageGUIController1 searchPageGUIController1) {
        searchPageGUIController1.setAllOldInput(userBean, oldInput);
    }
}
