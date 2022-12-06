package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.LoggedClubOwnerBean;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.ManageRequestsEngineering;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ManageRequestsGUIController1 implements Observer {

    private ClubOwnerBean clubOwnerBean;

    @FXML
    ListView listViewPendingRequests;
    @FXML
    private MenuClubOwnerGUIController1 menuController;

    public void setAll() throws SQLException, SystemException {
        this.menuController.setAll();
        this.clubOwnerBean = LoggedClubOwnerBean.getInstance();
        this.manageRequests();
    }

    @FXML
    private void manageRequests() throws SQLException, SystemException {
        this.listViewPendingRequests.getItems().clear();
        ManageRequestsEngineering.manageRequests(this, clubOwnerBean.getId());
    }

    @Override
    public void update(Object ob) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if(ob instanceof ManageRequestBean mRBean) {

            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ManageRequestsItem1.fxml")).openStream());
            } catch (IOException e) {
                try {
                    ExceptionHandler.handleException(e);
                } catch (SystemException ex) {
                    MyNotification.createNotification(e);
                }
            }

            ManageRequestsItemGUIController1 controller = fxmlLoader.getController();
            controller.setAll(mRBean);
            this.listViewPendingRequests.getItems().add(pane);
        }
    }

    public void backToClubOwnerPage(ActionEvent actionEvent) throws IOException {
        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }
}
