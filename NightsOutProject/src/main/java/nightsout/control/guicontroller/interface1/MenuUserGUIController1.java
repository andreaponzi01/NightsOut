package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import nightsout.utils.bean.LoggedClubOwnerBean;
import nightsout.utils.bean.LoggedUserBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceScene;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;

public class MenuUserGUIController1 {

    private UserBean userBean;

    @FXML
    protected Label usernameLabel;

    public MenuUserGUIController1() {
        //ignored
    }

    public void setLabelUserName(String username) { this.usernameLabel.setText(username); }

    public void setAll() throws SQLException {
        this.userBean = LoggedUserBean.getInstance();
        setLabelUserName(userBean.getUsername());
    }

    @FXML
    private void goToSubscriptionPage(ActionEvent actionEvent) throws SystemException {
        if (userBean.getVip()) {
            System.out.println("Already subscriptioned ");
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneSubscription(actionEvent, "/SubscriptionedVipPage1.fxml");
        }
        else
        {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneSubscription(actionEvent, "/SubscriptionVipPage1.fxml");
        }
    }

    @FXML
    private void goToSearchPage(ActionEvent actionEvent) throws SystemException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneSearch(actionEvent, "/SearchPage1.fxml");
    }

    @FXML
    private void goToCheckRequestsPage(ActionEvent actionEvent) throws SystemException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneCheckPendingRequests(actionEvent, "/CheckPendingRequestsPage1.fxml");
    }

    @FXML
    private void logout(ActionEvent actionEvent) throws IOException, SQLException {
        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to logout?: ");

        if(alert.showAndWait().get() == ButtonType.OK) {
            ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml");
            MySqlConnection.closeConnection();
            LoggedClubOwnerBean.DeleteInstance();
            LoggedUserBean.DeleteInstance();
        }
    }

    @FXML
    public void goToReviewPage(ActionEvent actionEvent) throws SystemException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneEndedBookedEvents(actionEvent, "/EndedBookedEventsPage1.fxml");
    }

    @FXML
    public void goToHome(ActionEvent actionEvent) throws SystemException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml");
    }

}
