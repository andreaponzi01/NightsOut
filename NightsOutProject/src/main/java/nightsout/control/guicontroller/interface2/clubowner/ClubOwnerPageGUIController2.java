package nightsout.control.guicontroller.interface2.clubowner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.control.guicontroller.interface2.item.ManageRequestsItemGUIController2;
import nightsout.utils.Session;
import nightsout.utils.bean.IdBean;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ClubOwnerPageGUIController2 implements Observer, Initializable {

    @FXML
    private ListView listViewPendingRequests;
    private JoinEventAppController joinEventAppController = new JoinEventAppController();

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if(ob instanceof ManageRequestBean mRBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ManageRequestsItem2.fxml")).openStream());
                ManageRequestsItemGUIController2 controller = fxmlLoader.getController();
                controller.setAll(mRBean, joinEventAppController);
                this.listViewPendingRequests.getItems().add(pane);
            } catch (IOException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            joinEventAppController.manageRequests(this, new IdBean(Session.getInstance().getClubOwner().getId()));
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}


