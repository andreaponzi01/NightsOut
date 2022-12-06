package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.CheckRequestsAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.LoggedUserBean;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.CheckRequestsEngineering;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class CheckRifiutedRequestsGUIController1 implements Observer {
    private UserBean userBean;

    @FXML
    ListView listViewRifiutedRequests;

    @FXML
    private MenuUserGUIController1 menuController;

    public void setAll() throws SQLException, SystemException {
        this.userBean = LoggedUserBean.getInstance();
        this.menuController.setAll();
        this.checkRifiutedRequests();
    }


    @FXML
    private void checkRifiutedRequests() throws SQLException, SystemException {
        this.listViewRifiutedRequests.getItems().clear();
        CheckRequestsEngineering.checkRifiutedRequests(this, this.userBean.getId());
    }

    @FXML
    private void backToPendingRequests(ActionEvent actionEvent) throws SystemException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneCheckPendingRequests(actionEvent, "/CheckPendingRequestsPage1.fxml");
    }



    @Override
    public void update(Object ob) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if(ob instanceof RequestBean rBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/CheckRequestsItem1.fxml")).openStream());
            } catch (IOException e) {
                try {
                    ExceptionHandler.handleException(e);
                } catch (SystemException ex) {
                    MyNotification.createNotification(e);
                }
            }
            CheckRequestsItemGUIController1 controller = fxmlLoader.getController();
            EventBean eventBean = CheckRequestsAppController.searchEventById(rBean.getIdEvent());
            controller.setAll(rBean, eventBean);

            this.listViewRifiutedRequests.getItems().add(pane);
        }
    }
}
