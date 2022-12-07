package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.LoggedClubOwnerBean;
import nightsout.utils.bean.LoggedUserBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceScene;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.sql.SQLException;

public class MenuUserGUIController1 {

    private UserBean userBean;

    @FXML
    protected Label usernameLabel;

    public MenuUserGUIController1() {
        //ignored
    }

    public void setLabelUserName(String username) { this.usernameLabel.setText(username); }

    public void setAll() {

        this.userBean = LoggedUserBean.getInstance();
        setLabelUserName(userBean.getUsername());
    }

    @FXML
    private void goToSubscriptionPage(ActionEvent actionEvent) {

        try {
            if (userBean.getVip()) {
                ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
                replacer.switchAndSetSceneSubscription(actionEvent, "/SubscriptionedVipPage1.fxml");
            } else {
                ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
                replacer.switchAndSetSceneSubscription(actionEvent, "/SubscriptionVipPage1.fxml");
            }
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    @FXML
    private void goToSearchPage(ActionEvent actionEvent) {
        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneSearch(actionEvent, "/SearchPage1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    @FXML
    private void goToCheckRequestsPage(ActionEvent actionEvent) {
        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneCheckPendingRequests(actionEvent, "/CheckPendingRequestsPage1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }


    @FXML
    private void logout(ActionEvent actionEvent) {

        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to logout?");

        try {
            if (alert.showAndWait().get() == ButtonType.OK) {
                ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml");
                MySqlConnection.closeConnection();
                LoggedUserBean.deleteInstance();
                LoggedClubOwnerBean.deleteInstance();
            }
        } catch (SQLException e) {
            SystemException ex = new SystemException();
            ex.initCause(e);
            MyNotification.createNotification(ex);
        }
    }

    @FXML
    public void goToReviewPage(ActionEvent actionEvent) {
        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneEndedBookedEvents(actionEvent, "/EndedBookedEventsPage1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    @FXML
    public void goToHome(ActionEvent actionEvent) {
        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

}
