package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.LoggedClubOwnerBean;
import nightsout.utils.bean.LoggedUserBean;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceScene;
import nightsout.utils.scene.ReplaceSceneDynamic1;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MenuClubOwnerGUIController1 implements Initializable {

    @FXML
    protected Label usernameLabel;
    @FXML
    protected Circle circleProfile;
    @FXML
    protected ImageView imageViewProfile;

    public MenuClubOwnerGUIController1() {
        //ignored
    }

    public void setLabelUserName(String username) { this.usernameLabel.setText(username); }

    public void setAll() {
        setLabelUserName(LoggedClubOwnerBean.getInstance().getUsername());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image img = new Image(LoggedClubOwnerBean.getInstance().getImg().toURI().toString());
        circleProfile.setFill(new ImagePattern(img));
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
    private void logout(ActionEvent actionEvent) {

        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to logout?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            try {
                ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml");
                MySqlConnection.closeConnection();
                LoggedUserBean.deleteInstance();
                LoggedClubOwnerBean.deleteInstance();
                LoggedUserBean.deleteInstance();
                FileUtils.cleanDirectory(new File("eventImgs"));
                FileUtils.cleanDirectory(new File("profileImgs"));
            } catch (SQLException | IOException e) {
                SystemException ex = new SystemException();
                ex.initCause(e);
                MyNotification.createNotification(ex);
            }
        }
    }
    @FXML
    public void goToHome(ActionEvent actionEvent) throws SystemException {

        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage1.fxml");
    }
}
