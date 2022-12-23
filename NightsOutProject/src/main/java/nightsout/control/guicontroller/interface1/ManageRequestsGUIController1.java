package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.LoggedClubOwnerBean1;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.ManageRequestsEngineering;
import nightsout.utils.scene.switchPage.SwitchAndSetPage1;

import java.io.IOException;
import java.util.Objects;

public class ManageRequestsGUIController1 implements Observer {

    private ClubOwnerBean1 clubOwnerBean1;

    @FXML
    ListView listViewPendingRequests;

    public void setAll() {

        this.clubOwnerBean1 = LoggedClubOwnerBean1.getInstance();
        this.manageRequests();
    }

    @FXML
    private void manageRequests() {

        try {
            this.listViewPendingRequests.getItems().clear();
            ManageRequestsEngineering.manageRequests(this, clubOwnerBean1.getId());
        } catch (SystemException e) {
            MyNotification.createNotification(e);
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
                MyNotification.createNotification(e);
            }
        }
    }

    public void backToClubOwnerPage(ActionEvent actionEvent) {

        try {
            SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
            replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }
}
