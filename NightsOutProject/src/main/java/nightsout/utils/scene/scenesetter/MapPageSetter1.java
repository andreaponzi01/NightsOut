package nightsout.utils.scene.scenesetter;

import nightsout.control.MapController;
import nightsout.utils.bean.interface1.EventBean1;

public class MapPageSetter1 {

    private MapPageSetter1() {
        // ignored
    }

    public static void setter(EventBean1 eventBean1, MapController mapController) {
        mapController.setAll(eventBean1);
    }
}
