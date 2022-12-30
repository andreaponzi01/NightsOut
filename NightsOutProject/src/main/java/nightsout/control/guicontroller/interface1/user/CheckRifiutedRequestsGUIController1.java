package nightsout.control.guicontroller.interface1.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.CheckRequestsAppController;
import nightsout.control.guicontroller.interface1.item.CheckRequestsItemGUIController1;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.interface1.LoggedUserBean1;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.engineering.CheckRequestsEngineering;
import nightsout.utils.scene.switchpage.SwitchPage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CheckRifiutedRequestsGUIController1 implements Observer, Initializable {
    private UserBean1 userBean1;
    @FXML
    ListView listViewRifiutedRequests;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.userBean1 = LoggedUserBean1.getInstance();
        try {
            CheckRequestsEngineering.checkRequests(this, this.userBean1.getId());
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }
    @FXML
    private void backToPendingRequests(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent,"/CheckPendingRequestsPage1.fxml");}

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if(ob instanceof RequestBean rBean) {
            if (Objects.equals(rBean.getStatus(), "declined")) {
                try {
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/CheckRequestsItem1.fxml")).openStream());
                    CheckRequestsItemGUIController1 controller = fxmlLoader.getController();
                    EventBean1 eventBean1 = new EventBean1(CheckRequestsAppController.searchEventByIdEvent(rBean.getIdEvent()));
                    controller.setAll(rBean, eventBean1);
                    this.listViewRifiutedRequests.getItems().add(pane);
                } catch(SystemException | IOException e){
                    CreateNotification.createNotification(e);
                }
            }
        }
    }
}