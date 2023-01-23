package nightsout.control.guicontroller.interface1.clubowner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.control.guicontroller.interface1.item.ManageRequestsItemGUIController1;
import nightsout.utils.Session;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.switchpage.SwitchPage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ManageRequestsGUIController1 implements Observer, Initializable {

    @FXML
    private ListView listViewPendingRequests;

    private SwitchPage switchPage = new SwitchPage();
    private JoinEventAppController joinEventAppController = new JoinEventAppController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            joinEventAppController.manageRequests(this, Session.getInstance().getClubOwner().getId());
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
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
                controller.setAll(mRBean, joinEventAppController);
                this.listViewPendingRequests.getItems().add(pane);
            } catch (IOException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
    }
    @FXML
    public void backToClubOwnerPage(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/ClubOwnerPage1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
