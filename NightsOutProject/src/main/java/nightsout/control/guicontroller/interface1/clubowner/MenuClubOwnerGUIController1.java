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
import nightsout.utils.Session;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.AlertNotFoundException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchPage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class MenuClubOwnerGUIController1 implements Initializable {

    @FXML
    private Label usernameLabel;
    @FXML
    private Circle circleProfile;
    @FXML
    private ImageView imageViewProfile;

    private SwitchPage switchPage = new SwitchPage();

    @FXML
    private void goToHome(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/ClubOwnerPage1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image img = new Image(Session.getInstance().getClubOwner().getImg().toURI().toString());
        circleProfile.setFill(new ImagePattern(img));
        this.usernameLabel.setText(Session.getInstance().getClubOwner().getUsername());
    }
    @FXML
    private void goToCreateEventPage(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/CreateEventPage1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void logout(ActionEvent actionEvent) {

        Optional<ButtonType> optional;
        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to logout?");
        alert.setTitle("Logout");
        try {
            optional = alert.showAndWait();
            if (optional.isEmpty()) {
                throw new AlertNotFoundException();
            }
            ButtonType value = optional.get();
            if (value == ButtonType.OK) {

                FileUtils.cleanDirectory(new File("profileImgs"));
                Session.getInstance().deleteSession();
                MySqlConnection.getInstance().closeConnection();
                FileUtils.cleanDirectory(new File("eventImgs"));
                switchPage.replaceScene(actionEvent, "/Welcome1.fxml");
            }
        } catch (SQLException | IOException e) {
            SystemException ex = new SystemException();
            ex.initCause(e);
            ErrorDialog.getInstance().handleException(ex);
        } catch (SystemException | AlertNotFoundException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void goToManageRequestsPage(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/ManageRequests1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void goToResponsePage(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/ReviewsCOPage1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
