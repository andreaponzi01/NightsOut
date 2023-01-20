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
import nightsout.utils.Session;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.SwitchPage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MenuClubOwnerGUIController2 implements Initializable {

    @FXML
    private Label labelUsername;
    @FXML
    private Label labelName;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelAddress;
    @FXML
    private Label labelCity;
    @FXML
    private Circle circleProfile;

    private SwitchPage switchPage = new SwitchPage();
    private MySqlConnection mySqlConnection = new MySqlConnection();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image img = new Image(Session.getInstance().getClubOwner().getImg().toURI().toString());
        circleProfile.setFill(new ImagePattern(img));
        this.labelUsername.setText(Session.getInstance().getClubOwner().getUsername());
        this.labelName.setText(Session.getInstance().getClubOwner().getName());
        this.labelAddress.setText(Session.getInstance().getClubOwner().getAddress());
        this.labelCity.setText(Session.getInstance().getClubOwner().getCity());
        this.labelEmail.setText(Session.getInstance().getClubOwner().getEmail());
    }

    @FXML
    public void goToHome(ActionEvent actionEvent){switchPage.replaceScene(actionEvent,"/ClubOwnerPage2.fxml");}
    @FXML
    public void goToManageEventsPage(ActionEvent actionEvent) {switchPage.replaceScene(actionEvent, "/ManageEventPage2.fxml");}
    @FXML
    public void goToCommunityPage(ActionEvent actionEvent){switchPage.replaceScene(actionEvent, "/ReviewsAndMakeResponsePage2.fxml");}
    @FXML
    private void logout(ActionEvent actionEvent) {

        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to logout?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            try {
                switchPage.replaceScene(actionEvent, "/Welcome2.fxml");
                mySqlConnection.closeConnection();
                Session.getInstance().deleteSession();
                FileUtils.cleanDirectory(new File("eventImgs"));
                FileUtils.cleanDirectory(new File("profileImgs"));
            } catch (SQLException | IOException e) {
                SystemException ex = new SystemException();
                ex.initCause(e);
                ErrorDialog.getInstance().handleException(ex);
            }
        }
    }
}
