package nightsout.utils.scenes.interface1;

import nightsout.control.guicontroller.interface1.SearchPageGUIController1;
import nightsout.utils.bean.UserBean;

public class SearchPageSetter1 {

    public static void setter(UserBean userBean, SearchPageGUIController1 searchPageGUIController1) {
        searchPageGUIController1.setAll(userBean);
    }
}
