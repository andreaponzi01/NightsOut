package nightsout.control;

import com.dlsc.gmapsfx.GoogleMapView;
import com.dlsc.gmapsfx.MapComponentInitializedListener;
import com.dlsc.gmapsfx.javascript.object.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import nightsout.control.appcontroller.EventPageDecoratorAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.LoggedClubOwnerBean2;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.LoggedClubOwnerBean1;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchPage.SwitchAndSetPage1;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

public class MapController implements Initializable, MapComponentInitializedListener {

    private EventBean1 eventBean;
    @FXML
    GoogleMapView location;

    public void setAll(EventBean1 eventBean) {
        this.eventBean = eventBean;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        location.addMapInitializedListener(this);
    }

    @Override
    public void mapInitialized() {

        String address = "";

        MapOptions mapOptions = new MapOptions();
        Double lat = 0.0;
        Double lng = 0.0;

        try {
            address = EventPageDecoratorAppController.getClubAddress(eventBean.getIdEvent());
            // Recuperiamo latitudine e longitudine dell'indirizzo del Club nel quale si svolgerà l'evento
            URL url = new URL("https://www.mapquestapi.com/geocoding/v1/address?key=QmskMXX88teOI9qXndnvrgGj4DGETyiF");

            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) con;

            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setRequestProperty("Content-Type", "application/json");

            String data = "{\n  \"location\": \"" + address  + "\",\n  \"options\": {\n    \"thumbMaps\": true\n  }\n}";
            byte[] out = data.getBytes(StandardCharsets.UTF_8);

            OutputStream stream = http.getOutputStream();
            stream.write(out);

            InputStream in = con.getInputStream();
            String encoding = con.getContentEncoding();
            encoding = encoding == null ? "UTF-8" : encoding;
            // Richiede Java 9 o versioni successive
            String body = new String(in.readAllBytes(), encoding);

            JSONObject object = new JSONObject(body);

            lat = Double.parseDouble(object.getJSONArray("results").getJSONObject(0).getJSONArray("locations").getJSONObject(0).getJSONObject("latLng").getString("lat"));
            lng = Double.parseDouble(object.getJSONArray("results").getJSONObject(0).getJSONArray("locations").getJSONObject(0).getJSONObject("latLng").getString("lng"));
            http.disconnect();

        } catch (JSONException | IOException e) {
            try {
                ExceptionHandler.handleException(e);
            } catch (SystemException ex) {
                MyNotification.createNotification(e);
            }
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }

        // Creiamo la mappa centrata sulla latitudine e longitudine corrispondente all'indirizzo del Club nel quale si svolgerà l'evento
        mapOptions.center(new LatLong(lat, lng))
                .mapType(MapTypeIdEnum.SATELLITE)
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

        markerOptions.position(new LatLong(lat, lng))
                .visible(Boolean.TRUE)
                .title("Prova1" + "'s Location");

        Marker marker = new Marker(markerOptions);
        map.addMarker(marker);
    }



    @FXML
    public void back(ActionEvent actionEvent) throws SystemException {
        try {
            SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
            String type= LoggedClubOwnerBean1.checkInstanceType();
            if(type.equals("FREE")){
                replacer.switchAndSetSceneEvent(actionEvent, "/EventPageDecoratorUser1.fxml", eventBean);
            }
            else{
                replacer.switchAndSetSceneEvent(actionEvent, "/EventPageDecoratorCO1.fxml", eventBean);
            }
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }
}
