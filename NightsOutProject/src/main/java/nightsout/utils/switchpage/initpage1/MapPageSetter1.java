package nightsout.utils.switchpage.initpage1;

import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.control.guicontroller.MapGUIController;
import nightsout.utils.bean.interface1.EventBean1;

public class MapPageSetter1 {


    public void setter(EventBean1 eventBean, MapGUIController mapGUIController) {
        mapGUIController.setAll(eventBean);
    }

    public void setter(EventBean1 eventBean, MapGUIController mapGUIController, JoinEventAppController joinEventAppController) {
        mapGUIController.setAll(eventBean, joinEventAppController);
    }
}
