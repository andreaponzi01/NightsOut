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
import nightsout.utils.scene.switchpage.SwitchPage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CheckPendingRequestsGUIController1 implements Observer, Initializable {
    @FXML
    private ListView listViewPendingRequests;
    private SwitchPage switchPage = new SwitchPage();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        CheckRequestAppController controller;

        try {
            controller = new CheckRequestAppController();
            controller.checkRequests(this, Session.getInstance().getUser().getId());
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
    @FXML
    private void goToRifiutedRequests(ActionEvent actionEvent) {switchPage.replaceScene(actionEvent,"/CheckRifiutedRequestsPage1.fxml");}

    @Override
    public void update(Object ob) {
        CheckRequestsItemGUIController1 controller;
        JoinEventAppController appController;
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if (ob instanceof RequestBean rBean && Objects.equals(rBean.getStatus(), "pending")) {
                try {
                    appController = new JoinEventAppController();
                    controller = fxmlLoader.getController();
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/CheckRequestsItem1.fxml")).openStream());
                    fxmlLoader.getController();
                    EventBean1 eventBean1 = new EventBean1(appController.searchEventByIdEvent(rBean.getIdEvent()));
                    controller.setAll(rBean, eventBean1);
                    this.listViewPendingRequests.getItems().add(pane);
                } catch (SystemException | IOException e) {
                    ErrorDialog.getInstance().handleException(e);
                }
        }
    }
    @FXML
    public void backToUserPage(ActionEvent actionEvent) {switchPage.replaceScene(actionEvent,"/UserPage1.fxml");}
}
