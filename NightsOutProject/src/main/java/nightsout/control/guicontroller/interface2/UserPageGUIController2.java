package nightsout.control.guicontroller.interface2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.control.guicontroller.interface1.EventItemGUIController1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.LoggedUserBean1;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.NextEventsEngineering;

import java.io.IOException;
import java.util.Objects;

public class UserPageGUIController2 implements Observer {

    @FXML
    private ListView listViewNextEvents;


    public void setAll() throws SystemException{
        NextEventsEngineering.nextEvents(this, LoggedUserBean1.getInstance().getId());
    }


    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if(ob instanceof EventBean1 eBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem1.fxml")).openStream());
                EventItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(eBean);
                this.listViewNextEvents.getItems().add(pane);
            } catch (IOException e) {
                MyNotification.createNotification(e);
            }
        }
    }
}
