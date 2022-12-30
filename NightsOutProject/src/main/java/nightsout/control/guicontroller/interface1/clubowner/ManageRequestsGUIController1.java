package nightsout.control.guicontroller.interface1.clubowner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.interface1.item.ManageRequestsItemGUIController1;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.interface1.LoggedClubOwnerBean1;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.engineering.ManageRequestsEngineering;
import nightsout.utils.scene.switchpage.SwitchPage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ManageRequestsGUIController1 implements Observer, Initializable {

    @FXML
    ListView listViewPendingRequests;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            ManageRequestsEngineering.manageRequests(this, LoggedClubOwnerBean1.getInstance().getId());
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if(ob instanceof ManageRequestBean mRBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ManageRequestsItem1.fxml")).openStream());
                ManageRequestsItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(mRBean);
                this.listViewPendingRequests.getItems().add(pane);
            } catch (IOException e) {
                CreateNotification.createNotification(e);
            }
        }
    }
    @FXML
    public void backToClubOwnerPage(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent,"/ClubOwnerPage1.fxml");}
}
