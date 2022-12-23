package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.CheckRequestsAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.LoggedUserBean1;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.CheckRequestsEngineering;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.util.Objects;

public class CheckPendingRequestsGUIController1 implements Observer {
    private UserBean1 userBean1;

    @FXML
    ListView listViewPendingRequests;

    public void setAll() {

        this.userBean1 = LoggedUserBean1.getInstance();
        this.checkRequests();
    }


    @FXML
    private void checkRequests() {

        try {
            this.listViewPendingRequests.getItems().clear();
            CheckRequestsEngineering.checkPendingRequests(this, this.userBean1.getId());
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    @FXML
    private void goToRifiutedRequests(ActionEvent actionEvent) {

        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneCheckRifiutedRequests(actionEvent, "/CheckRifiutedRequestsPage1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }



    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if (ob instanceof RequestBean rBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/CheckRequestsItem1.fxml")).openStream());
                CheckRequestsItemGUIController1 controller = fxmlLoader.getController();
                EventBean1 eventBean1 = new EventBean1(CheckRequestsAppController.searchEventById(rBean.getIdEvent()));
                controller.setAll(rBean, eventBean1);
                this.listViewPendingRequests.getItems().add(pane);
            } catch (SystemException | IOException e) {
                MyNotification.createNotification(e);
            }
        }
    }


    @FXML
    public void backToUserPage(ActionEvent actionEvent) {
        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }
}
