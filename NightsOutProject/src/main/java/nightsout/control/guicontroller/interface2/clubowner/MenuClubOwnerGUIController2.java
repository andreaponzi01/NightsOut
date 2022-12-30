package nightsout.control.guicontroller.interface2.clubowner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.interface2.LoggedClubOwnerBean2;
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

public class MenuClubOwnerGUIController2 implements Initializable {

    @FXML
    Label labelUsername;
    @FXML
    Label labelName;
    @FXML
    Label labelEmail;
    @FXML
    Label labelAddress;
    @FXML
    Label labelCity;
    @FXML
    Circle circleProfile;

    public MenuClubOwnerGUIController2() {
        //ignored
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image img = new Image(LoggedClubOwnerBean2.getInstance().getImg().toURI().toString());
        circleProfile.setFill(new ImagePattern(img));
        this.labelUsername.setText(LoggedClubOwnerBean2.getInstance().getUsername());
        this.labelName.setText(LoggedClubOwnerBean2.getInstance().getName());
        this.labelAddress.setText(LoggedClubOwnerBean2.getInstance().getAddress());
        this.labelCity.setText(LoggedClubOwnerBean2.getInstance().getCity());
        this.labelEmail.setText(LoggedClubOwnerBean2.getInstance().getEmail());
    }

    @FXML
    public void goToHome(ActionEvent actionEvent){SwitchPage.replaceScene(actionEvent,"/ClubOwnerPage2.fxml");}
    @FXML
    public void goToManageEventsPage(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent, "/ManageEventPage2.fxml");}
    @FXML
    public void goToCommunityPage(ActionEvent actionEvent){SwitchPage.replaceScene(actionEvent, "/ReviewsAndMakeResponsePage2.fxml");}
    @FXML
    private void logout(ActionEvent actionEvent) {

        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to logout?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            try {
                SwitchPage.replaceScene(actionEvent, "/Welcome2.fxml");
                MySqlConnection.closeConnection();
                LoggedUserBean1.deleteInstance();
                LoggedClubOwnerBean2.deleteInstance();
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
}
