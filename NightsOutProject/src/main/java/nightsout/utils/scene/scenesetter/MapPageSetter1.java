package nightsout.utils.scene.scenesetter;

import nightsout.control.MapController;
import nightsout.utils.bean.EventBean;

public class MapPageSetter1 {
    public static void setter(EventBean eventBean, MapController mapController) {
        mapController.setAll(eventBean);
    }
}
