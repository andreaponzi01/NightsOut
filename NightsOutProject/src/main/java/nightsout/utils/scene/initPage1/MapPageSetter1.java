package nightsout.utils.scene.initPage1;

import nightsout.control.MapController;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.interface1.EventBean1;

public class MapPageSetter1 {

    private MapPageSetter1() {
        // ignored
    }

    public static void setter(EventBean1 eventBean, MapController mapController) {
        mapController.setAll(eventBean);
    }
}
