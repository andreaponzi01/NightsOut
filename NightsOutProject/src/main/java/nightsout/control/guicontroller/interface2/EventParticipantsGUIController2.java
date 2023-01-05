package nightsout.control.guicontroller.interface2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.utils.bean.interface2.LoggedClubOwnerBean2;
import nightsout.utils.exception.CreateNotification;
import nightsout.control.guicontroller.interface2.item.UserItemGUIController2;
import nightsout.utils.bean.*;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.engineering.EventParticipantsEngineering;
import nightsout.utils.scene.switchpage.SwitchAndSetPage2;

import java.io.IOException;
import java.util.Objects;

public class EventParticipantsGUIController2 implements Observer {

    private EventBean2 eventBean;
    @FXML
    ListView listViewParticipants;
    @FXML
    Label labelEventName;

    public void setAll(EventBean2 eBean) throws SystemException {

        this.eventBean=eBean;
        EventParticipantsEngineering.eventParticipants(this, eBean.getIdEvent());
        this.labelEventName.setText("Participants of: "+eBean.getName());
    }

    public void backToUserPage(ActionEvent actionEvent) {
        try{
            String type = LoggedClubOwnerBean2.checkInstanceType();
            if (type.equals("FREE")) {
                SwitchAndSetPage2 replacer = new SwitchAndSetPage2();
                replacer.switchAndSetSceneEvent(actionEvent, "/EventPageFromUser2.fxml",eventBean);
            }else {
                SwitchAndSetPage2 replacer = new SwitchAndSetPage2();
                replacer.switchAndSetSceneEvent(actionEvent, "/EventPageFromCO2.fxml",eventBean);
            }
        }catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if(ob instanceof UserBean uBean){
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/UserItem2.fxml")).openStream());
                UserItemGUIController2 controller = fxmlLoader.getController();
                controller.setAll(new UserBean2(uBean));
                this.listViewParticipants.getItems().add(pane);
            } catch (IOException e) {
                CreateNotification.createNotification(e);
            }
        }
    }
}
