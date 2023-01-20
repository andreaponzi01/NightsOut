package nightsout.control.guicontroller.interface1.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.CheckRequestAppController;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.control.guicontroller.interface1.item.CheckRequestsItemGUIController1;
import nightsout.utils.Session;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.scene.SwitchPage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CheckRifiutedRequestsGUIController1 implements Observer, Initializable {
    @FXML
    private ListView listViewRifiutedRequests;
    private SwitchPage switchPage = new SwitchPage();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        CheckRequestAppController controller;
        try {
            controller = new CheckRequestAppController();
            controller.checkRequests(this,  Session.getInstance().getUser().getId());
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
    @FXML
    private void backToPendingRequests(ActionEvent actionEvent) {switchPage.replaceScene(actionEvent,"/CheckPendingRequestsPage1.fxml");}

    @Override
    public void update(Object ob) {

        JoinEventAppController appController;
        CheckRequestsItemGUIController1 controller;
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if(ob instanceof RequestBean rBean && Objects.equals(rBean.getStatus(), "declined")) {
                try {
                    appController = new JoinEventAppController();
                    controller = fxmlLoader.getController();
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/CheckRequestsItem1.fxml")).openStream());
                    EventBean1 eventBean1 = new EventBean1(appController.searchEventByIdEvent(rBean.getIdEvent()));
                    controller.setAll(rBean, eventBean1);
                    this.listViewRifiutedRequests.getItems().add(pane);
                } catch(SystemException | IOException e){
                    ErrorDialog.getInstance().handleException(e);
                }
        }
    }
}