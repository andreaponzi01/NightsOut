package nightsout.control.guicontroller.interface2.clubowner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.interface2.item.ManageRequestsItemGUIController2;
import nightsout.utils.bean.LoggedBean;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.engineering.ManageRequestsEngineering;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ClubOwnerPageGUIController2 implements Observer, Initializable {

    @FXML
    private ListView listViewPendingRequests;

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
                ExceptionHandler.handleException(e);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            ManageRequestsEngineering.manageRequests(this, LoggedBean.getInstance().getClubOwner().getId());
        } catch (SystemException e) {
            ExceptionHandler.handleException(e);
        }
    }
}


