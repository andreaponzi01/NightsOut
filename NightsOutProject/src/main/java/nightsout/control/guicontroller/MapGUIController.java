package nightsout.control.guicontroller;

import com.dlsc.gmapsfx.GoogleMapView;
import com.dlsc.gmapsfx.MapComponentInitializedListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import nightsout.utils.Session;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.engineering.MapEngineering;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchAndSetPage1;

import java.net.URL;
import java.util.ResourceBundle;

public class MapGUIController implements Initializable, MapComponentInitializedListener {

    private EventBean1 eventBean;
    @FXML
    private GoogleMapView location;
    private SwitchAndSetPage1 switchAndSetPage1 = new SwitchAndSetPage1();

    public void setAll(EventBean1 eventBean) {
        this.eventBean = eventBean;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        location.addMapInitializedListener(this);
    }

    @Override
    public void mapInitialized() {

        MapEngineering mapEngineering = new MapEngineering();
        mapEngineering.createMap(eventBean, location);
    }



    @FXML
    public void back(ActionEvent actionEvent) throws SystemException {
        try {
            String type = Session.getInstance().checkInstanceType();
            if(type.equalsIgnoreCase("Free")){
                switchAndSetPage1.switchAndSetSceneEvent(actionEvent, "/EventPageDecoratorUser1.fxml", eventBean);
            }
            else{
                switchAndSetPage1.switchAndSetSceneEvent(actionEvent, "/EventPageDecoratorCO1.fxml", eventBean);
            }
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
