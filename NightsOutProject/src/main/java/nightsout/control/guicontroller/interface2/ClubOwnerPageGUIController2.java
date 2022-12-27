package nightsout.control.guicontroller.interface2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.control.guicontroller.interface2.Item.ManageRequestsItemGUIController2;
import nightsout.utils.bean.LoggedClubOwnerBean2;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.ManageRequestsEngineering;

import java.io.IOException;
import java.util.Objects;

public class ClubOwnerPageGUIController2 implements Observer {

    @FXML
    private ListView listViewPendingRequests;

    public void setAll() throws SystemException {
        this.manageRequests();
    }

    @FXML
    private void manageRequests() {

        try {
            this.listViewPendingRequests.getItems().clear();
            ManageRequestsEngineering.manageRequests(this, LoggedClubOwnerBean2.getInstance().getId());
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
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ManageRequestsItem2.fxml")).openStream());
                ManageRequestsItemGUIController2 controller = fxmlLoader.getController();
                controller.setAll(mRBean);
                this.listViewPendingRequests.getItems().add(pane);
            } catch (IOException e) {
                MyNotification.createNotification(e);
            }
        }
    }


}


