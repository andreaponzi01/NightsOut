package nightsout.utils.switchpage.initpage1;

import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.control.guicontroller.interface1.ViewUserPageGUIController1;
import nightsout.utils.bean.interface1.UserBean1;

public class ViewUserPageSetter1 {

    public void setter(UserBean1 userBean, ViewUserPageGUIController1 viewUserPageGUIController1) {
        viewUserPageGUIController1.setAll(userBean);
    }

    public void setter(UserBean1 userBean, ViewUserPageGUIController1 viewUserPageGUIController1, JoinEventAppController joinEventAppController) {
        viewUserPageGUIController1.setAll(userBean, joinEventAppController);
    }



}
