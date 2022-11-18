package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.utils.ManageRequestsEngineering;
import nightsout.utils.NextEventsEngineering;
import nightsout.utils.Observer;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.scene.ReplaceScene;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class UserPageGUIController1 implements Observer {

    @FXML
    protected Label usernameLabel;

    protected UserBean userBean;

    @FXML
    private ListView listViewNextEvents;

    public void setLabelUserName(String username) { this.usernameLabel.setText(username); }

    public void setAll(UserBean userBean) throws SQLException {
        this.userBean = userBean;
        setLabelUserName(userBean.getUsername());
        NextEventsEngineering.nextEvents(this, userBean.getId());
    }

    @FXML
    private void goToSubscriptionPage(ActionEvent actionEvent) throws IOException {
        if (userBean.getVip()) {
            System.out.println("Already subscriptioned ");
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneSubscription(actionEvent, "/SubscriptionedVipPage1.fxml", userBean);
        }
        else
        {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneSubscription(actionEvent, "/SubscriptionVipPage1.fxml", userBean);
        }
    }

    @FXML
    private void goToSearchPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneSearch(actionEvent, "/SearchPage1.fxml", userBean);
    }

    @FXML
    private void goToCheckRequestsPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneCheckRequests(actionEvent, "/CheckRequests1.fxml", userBean);
    }

    @FXML
    private void logout(ActionEvent actionEvent) throws IOException, SQLException {
        ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml");
        MySqlConnection.closeConnection();
    }

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if(ob instanceof EventBean eBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/NextEventItem1.fxml")).openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            NextEventItemGUIController1 controller = fxmlLoader.getController();
            controller.setAll(userBean, eBean);
            this.listViewNextEvents.getItems().add(pane);
        }
    }
    @FXML
    public void goToReviewPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneEndedBookedEvents(actionEvent, "/EndedBookedEventsPage1.fxml", userBean);
    }
}
