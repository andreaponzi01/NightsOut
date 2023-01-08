package nightsout.control.guicontroller.interface1.clubowner;

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
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.interface1.LoggedClubOwnerBean1;
import nightsout.utils.bean.interface1.LoggedUserBean1;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchPage;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image img = new Image(LoggedClubOwnerBean1.getInstance().getImg().toURI().toString());
        circleProfile.setFill(new ImagePattern(img));
        this.usernameLabel.setText(LoggedClubOwnerBean1.getInstance().getUsername());
    }
    @FXML
    public void goToCreateEventPage(ActionEvent actionEvent){SwitchPage.replaceScene(actionEvent,"/CreateEventPage1.fxml");}
    @FXML
    public void goToManageRequestsPage(ActionEvent actionEvent){SwitchPage.replaceScene(actionEvent,"/ManageRequests1.fxml");}
    @FXML
    public void goToResponsePage(ActionEvent actionEvent){SwitchPage.replaceScene(actionEvent,"/ReviewResponsePage1.fxml");}
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
                CreateNotification.createNotification(ex);
            }
        }
    }
    @FXML
    public void goToHome(ActionEvent actionEvent){SwitchPage.replaceScene(actionEvent,"/ClubOwnerPage1.fxml");}
}
