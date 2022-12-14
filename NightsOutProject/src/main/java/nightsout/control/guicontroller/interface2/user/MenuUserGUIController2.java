package nightsout.control.guicontroller.interface2.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import nightsout.utils.bean.LoggedBean;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchPage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MenuUserGUIController2 implements Initializable {

    private UserBean2 userBean;
    @FXML
    protected Button buttonVip;
    @FXML
    protected Label labelUsername;
    @FXML
    protected Label labelCognome;
    @FXML
    protected Label labelEmail;
    @FXML
    protected Label labelBirthday;
    @FXML
    protected Label labelNome;
    @FXML
    protected Circle circleProfile;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.userBean = new UserBean2(LoggedBean.getInstance().getUser());
        Image img = new Image(userBean.getImg().toURI().toString());
        circleProfile.setFill(new ImagePattern(img));
        this.labelUsername.setText(userBean.getUsername());
        this.labelCognome.setText(userBean.getSurname());
        this.labelEmail.setText(userBean.getEmail());
        this.labelNome.setText(userBean.getName());
        if (userBean.getVip()){
            this.buttonVip.setText("Sei un VIP!");
            this.labelBirthday.setText("Signed on: "+userBean.getCreationDateVIP().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
        }
        else
            this.buttonVip.setText("Diventa un VIP!");
    }

    @FXML
    private void goToSubscriptionPage(ActionEvent actionEvent) {
        if(!userBean.getVip()) {
            SwitchPage.replaceScene(actionEvent,"/SubscriptionVipPage2.fxml");
        }
    }

    @FXML
    private void goToCheckRequestsPage(ActionEvent actionEvent) {
            SwitchPage.replaceScene(actionEvent,"/CheckRequestsAndReviewPage2.fxml");
    }

    @FXML
    private void logout(ActionEvent actionEvent) {

        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to logout?");
        try {
            if (alert.showAndWait().get() == ButtonType.OK) {
                SwitchPage.replaceScene(actionEvent, "/Welcome2.fxml");
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
    public void goToHome(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent,"/UserPage2.fxml");
    }
}
