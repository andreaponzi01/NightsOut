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
import nightsout.utils.bean.LoggedClubOwnerBean1;
import nightsout.utils.bean.LoggedUserBean1;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchPage.SwitchPage;
import nightsout.utils.scene.switchPage.SwitchAndSetPage1;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image img = new Image(LoggedClubOwnerBean1.getInstance().getImg().toURI().toString());
        circleProfile.setFill(new ImagePattern(img));
        setLabelUserName(LoggedClubOwnerBean1.getInstance().getUsername());
    }

    @FXML
    public void goToCreateEventPage(ActionEvent actionEvent) throws SystemException {

        SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
        replacer.switchAndSetScene(actionEvent, "/CreateEventPage1.fxml");
    }

    @FXML
    public void goToManageRequestsPage(ActionEvent actionEvent) throws SystemException {

        SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
        replacer.switchAndSetScene(actionEvent, "/ManageRequests1.fxml");
    }

    public void goToResponsePage(ActionEvent actionEvent) throws SystemException {

        SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
        replacer.switchAndSetScene(actionEvent, "/ReviewResponsePage1.fxml");
    }

    @FXML
    private void logout(ActionEvent actionEvent) {

        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to logout?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            try {
                SwitchPage.replaceScene(actionEvent, "/Welcome1.fxml");
                MySqlConnection.closeConnection();
                LoggedUserBean1.deleteInstance();
                LoggedClubOwnerBean1.deleteInstance();
                LoggedUserBean1.deleteInstance();
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

        SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
        replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage1.fxml");
    }
}
