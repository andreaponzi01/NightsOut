package nightsout.control.guicontroller.interface1.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import nightsout.utils.Session;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchPage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MenuUserGUIController1  implements Initializable {

    private UserBean1 userBean1;
    private SwitchPage switchPage = new SwitchPage();
    @FXML
    private Label usernameLabel;
    @FXML
    private Circle circleProfile;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image img = new Image(Session.getInstance().getUser().getImg().toURI().toString());
        circleProfile.setFill(new ImagePattern(img));
        this.userBean1 = new UserBean1(Session.getInstance().getUser());
        this.usernameLabel.setText(userBean1.getUsername());
    }

    public void goToCheckRequestsPage(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/CheckPendingRequestsPage1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    public void goToSubscriptionPage(ActionEvent actionEvent) {

        try {
            if (userBean1.getVip())
                switchPage.replaceScene(actionEvent, "/SubscriptionedVipPage1.fxml");
            else
                switchPage.replaceScene(actionEvent, "/SubscriptionVipPage1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    public void goToSearchPage(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/SearchPage1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    public void logout(ActionEvent actionEvent) {

        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to logout?");

        try {
            if (alert.showAndWait().get() == ButtonType.OK) {

                FileUtils.cleanDirectory(new File("eventImgs"));
                FileUtils.cleanDirectory(new File("profileImgs"));
                switchPage.replaceScene(actionEvent, "/Welcome1.fxml");
                MySqlConnection.getInstance().closeConnection();
                Session.getInstance().deleteSession();
            }

        }catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        } catch (SQLException | IOException e) {
            SystemException ex = new SystemException();
            ex.initCause(e);
            ErrorDialog.getInstance().handleException(ex);
        }
    }
    @FXML
    public void goToReviewPage(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/EndedBookedEventsPage1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    public void goToHome(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/UserPage1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}