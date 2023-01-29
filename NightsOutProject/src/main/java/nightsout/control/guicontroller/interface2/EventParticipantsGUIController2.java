package nightsout.control.guicontroller.interface2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.control.guicontroller.interface2.item.UserItemGUIController2;
import nightsout.utils.Session;
import nightsout.utils.bean.IdBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.engineering.EventParticipantsEngineering;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.switchpage.SwitchAndSetPage2;

import java.io.IOException;
import java.util.Objects;

public class EventParticipantsGUIController2 implements Observer {

    private EventBean2 eventBean;
    @FXML
    private ListView<Pane> listViewParticipants;
    @FXML
    private Label labelEventName;
    private SwitchAndSetPage2 switchAndSetPage2 = new SwitchAndSetPage2();

    private JoinEventAppController joinEventAppController;

    public void setAll(EventBean2 eBean) throws SystemException {

        this.eventBean=eBean;
        EventParticipantsEngineering eventParticipantsEngineering = new EventParticipantsEngineering();
        eventParticipantsEngineering.eventParticipants(this, new IdBean(eBean.getIdEvent()));
        this.labelEventName.setText("Participants of: "+eBean.getName());
    }

    public void setAll(EventBean2 eBean, JoinEventAppController joinEventAppController) throws SystemException {

        this.joinEventAppController = joinEventAppController;
        setAll(eBean);
    }

    @FXML
    private void backToUserPage(ActionEvent actionEvent) {
        try{
            String type = Session.getInstance().checkInstanceType();
            if (type.equalsIgnoreCase("FREE"))
                switchAndSetPage2.switchAndSetSceneEvent(actionEvent, "/EventPageFromUser2.fxml",eventBean, joinEventAppController);
            else
                switchAndSetPage2.switchAndSetSceneEvent(actionEvent, "/EventPageFromCO2.fxml",eventBean);
        }catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
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
                controller.setAll(new UserBean2(uBean), joinEventAppController);
                this.listViewParticipants.getItems().add(pane);
            } catch (IOException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
    }
}
