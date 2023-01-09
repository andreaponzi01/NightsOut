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
import nightsout.utils.bean.LoggedBean;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchPage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MenuUserGUIController1  implements Initializable {

    private UserBean1 userBean1;
    @FXML
    protected Label usernameLabel;
    @FXML
    protected Circle circleProfile;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image img = new Image(LoggedBean.getInstance().getUser().getImg().toURI().toString());
        circleProfile.setFill(new ImagePattern(img));
        this.userBean1 = new UserBean1(LoggedBean.getInstance().getUser());
        this.usernameLabel.setText(userBean1.getUsername());
    }
    @FXML
    private void goToSubscriptionPage(ActionEvent actionEvent) {

        if (userBean1.getVip())
            SwitchPage.replaceScene(actionEvent,"/SubscriptionedVipPage1.fxml");
        else
            SwitchPage.replaceScene(actionEvent,"/SubscriptionVipPage1.fxml");
    }
    @FXML
    private void goToSearchPage(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent,"/SearchPage1.fxml");}
    @FXML
    private void goToCheckRequestsPage(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent,"/CheckPendingRequestsPage1.fxml");}
    @FXML
    private void logout(ActionEvent actionEvent) {

        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to logout?");

        try {
            if (alert.showAndWait().get() == ButtonType.OK) {
                SwitchPage.replaceScene(actionEvent, "/Welcome1.fxml");
                MySqlConnection.closeConnection();
                LoggedBean.getInstance().deleteSession();
                FileUtils.cleanDirectory(new File("eventImgs"));
                FileUtils.cleanDirectory(new File("profileImgs"));
            }
        } catch (SQLException | IOException e) {
            SystemException ex = new SystemException();
            ex.initCause(e);
            CreateNotification.createNotification(ex);
        }
    }
    @FXML
    public void goToReviewPage(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent,"/EndedBookedEventsPage1.fxml");}
    @FXML
    public void goToHome(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent,"/UserPage1.fxml");}
}