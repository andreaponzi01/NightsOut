package nightsout.control.guicontroller.interface1.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.CheckRequestsAppController;
import nightsout.control.guicontroller.interface1.item.CheckRequestsItemGUIController1;
import nightsout.utils.bean.LoggedBean;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.engineering.CheckRequestsEngineering;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.scene.switchpage.SwitchPage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CheckPendingRequestsGUIController1 implements Observer, Initializable {
    @FXML
    ListView listViewPendingRequests;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            CheckRequestsEngineering.checkRequests(this, LoggedBean.getInstance().getUser().getId());
        } catch (SystemException e) {
            ExceptionHandler.handleException(e);
        }
    }
    @FXML
    private void goToRifiutedRequests(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent,"/CheckRifiutedRequestsPage1.fxml");}

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if (ob instanceof RequestBean rBean && Objects.equals(rBean.getStatus(), "pending")) {
                try {
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/CheckRequestsItem1.fxml")).openStream());
                    CheckRequestsItemGUIController1 controller = fxmlLoader.getController();
                    EventBean1 eventBean1 = new EventBean1(CheckRequestsAppController.searchEventByIdEvent(rBean.getIdEvent()));
                    controller.setAll(rBean, eventBean1);
                    this.listViewPendingRequests.getItems().add(pane);
                } catch (SystemException | IOException e) {
                    ExceptionHandler.handleException(e);
                }
        }
    }
    @FXML
    public void backToUserPage(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent,"/UserPage1.fxml");}
}
