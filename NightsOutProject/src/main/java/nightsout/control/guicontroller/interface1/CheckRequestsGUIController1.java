package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.utils.CheckRequestsEngineering;
import nightsout.utils.Observer;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.util.Objects;

public class CheckRequestsGUIController1 implements Observer {
    private UserBean userBean;

    @FXML
    ListView listViewPendingRequests;

    @FXML
    public void backToWelcomePage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml", userBean, null);
    }

    @FXML
    private void checkRequests() {
        this.listViewPendingRequests.getItems().clear();
        CheckRequestsEngineering.checkRequests(this, userBean.getId());
    }

    public void setAll(UserBean userBean) {
        this.userBean = userBean;
        this.checkRequests();
    }

    @Override
    public void update(Object ob) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if(ob instanceof RequestBean rBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/CheckRequestsItem1.fxml")).openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            CheckRequestsItemGUIController1 controller = fxmlLoader.getController();
            controller.setAll(rBean);

            this.listViewPendingRequests.getItems().add(pane);
        }
    }
}
