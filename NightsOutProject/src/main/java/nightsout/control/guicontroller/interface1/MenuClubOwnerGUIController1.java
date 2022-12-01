package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.LoggedClubOwnerBean;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceScene;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.sql.SQLException;

public class MenuClubOwnerGUIController1 {

    private ClubOwnerBean loggedClubOwner;

    @FXML
    protected Label usernameLabel;

    public MenuClubOwnerGUIController1() {
        //ignored
    }

    public void setLabelUserName(String username) { this.usernameLabel.setText(username); }

    public void setAll() throws SQLException {
        this.loggedClubOwner = LoggedClubOwnerBean.getInstance();
        setLabelUserName(loggedClubOwner.getUsername());
    }

    @FXML
    public void goToCreateEventPage(ActionEvent actionEvent) throws SystemException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneCreateEvent(actionEvent, "/CreateEventPage1.fxml");
    }

    @FXML
    public void goToManageRequestsPage(ActionEvent actionEvent) throws SystemException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneManageRequest(actionEvent, "/ManageRequests1.fxml");
    }

    public void goToResponsePage(ActionEvent actionEvent) throws SystemException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneReviewResponse(actionEvent, "/ReviewResponsePage1.fxml");
    }

    @FXML
    public void goToReviewsPage(ActionEvent actionEvent) throws SystemException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneReviewAndResponse(actionEvent, "/ReviewAndResponsePage1.fxml");
    }

    @FXML
    private void logout(ActionEvent actionEvent) throws SQLException {
        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to logout?:");

        if(alert.showAndWait().get() == ButtonType.OK){
            ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml");
            MySqlConnection.closeConnection();
            LoggedClubOwnerBean.DeleteInstance();
        }
    }
    @FXML
    public void goToHome(ActionEvent actionEvent) throws SystemException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage1.fxml");
    }
}
