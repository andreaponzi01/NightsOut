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
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.CheckRequestsEngineering;
import nightsout.utils.scene.ReplaceSceneDynamic1;

public class CheckPendingRequestsGUIController1 implements Observer {
    private UserBean userBean;

    @FXML
    ListView listViewPendingRequests;

    @FXML
    private MenuUserGUIController1 menuController;

    public void setAll() {

            this.userBean = LoggedUserBean.getInstance();
            this.menuController.setAll();
            this.checkRequests();
    }


    @FXML
    private void checkRequests() {

        try {
            this.listViewPendingRequests.getItems().clear();
            CheckRequestsEngineering.checkPendingRequests(this, this.userBean.getId());
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

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Pane pane = null;
            if (ob instanceof RequestBean rBean) {
                CheckRequestsItemGUIController1 controller = fxmlLoader.getController();
                EventBean eventBean = CheckRequestsAppController.searchEventById(rBean.getIdEvent());
                controller.setAll(rBean, eventBean);
                this.listViewPendingRequests.getItems().add(pane);
            }
        } catch (SystemException e) {
            MyNotification.createNotification(e);
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
