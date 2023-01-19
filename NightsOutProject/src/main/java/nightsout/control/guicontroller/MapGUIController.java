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
import nightsout.utils.scene.switchpage.SwitchAndSetPage1;

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

        /*
        MapOptions mapOptions = new MapOptions();
        Double[] latlong= new Double[2];
        try {
            latlong = EventPageAppController.findLocation(eventBean.getIdEvent());
        } catch (SystemException e) {
            ExceptionHandler.getInstance().handleException(e);
        }

        // Creiamo la mappa centrata sulla latitudine e longitudine corrispondente all'indirizzo del Club nel quale si svolgerà l'evento
        mapOptions.center(new LatLong(latlong[0],latlong[1]))
                .mapType(MapTypeIdEnum.HYBRID)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(18);

        GoogleMap map = location.createMap(mapOptions);
        // Aggiungiamo il marcatore sulla Mappa
        MarkerOptions markerOptions = new MarkerOptions();

        markerOptions.position(new LatLong(latlong[0],latlong[1]))
                .visible(Boolean.TRUE)
                .title("Prova1" + "'s Location");

        Marker marker = new Marker(markerOptions);
        map.addMarker(marker);
        */
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
