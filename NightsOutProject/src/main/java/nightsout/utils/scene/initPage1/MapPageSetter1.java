package nightsout.utils.scene.initpage1;

import nightsout.control.guicontroller.MapGUIController;
import nightsout.utils.bean.interface1.EventBean1;

public class MapPageSetter1 {

    private MapPageSetter1() {
        // ignored
    }

    public static void setter(EventBean1 eventBean, MapGUIController mapGUIController) {
        mapGUIController.setAll(eventBean);
    }
}
