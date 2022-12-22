package nightsout.control.guicontroller.interface2;

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
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.LoggedClubOwnerBean1;
import nightsout.utils.bean.LoggedUserBean1;
import nightsout.utils.bean.interface1.UserBean1;
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

public class MenuUserGUIController2 implements Initializable {

    private UserBean1 userBean;
    @FXML
    protected Button buttonVip;
    @FXML
    protected Label labelUsername;
    @FXML
    protected Label labelCognome;
    @FXML
    protected Label labelEmail;
    @FXML
    protected Label labelNome;
    @FXML
    protected Circle circleProfile;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image img = new Image(LoggedUserBean1.getInstance().getImg().toURI().toString());
        circleProfile.setFill(new ImagePattern(img));
        this.userBean = LoggedUserBean1.getInstance();
        this.labelUsername.setText(userBean.getUsername());
        this.labelCognome.setText(userBean.getSurname());
        this.labelEmail.setText(userBean.getEmail());
        this.labelNome.setText(userBean.getName());
        if (userBean.getVip())
            this.buttonVip.setText("Sei un VIP!");
        else
            this.buttonVip.setText("Diventa un VIP!");
    }

    @FXML
    private void goToSubscriptionPage(ActionEvent actionEvent) {

        try {
            if(userBean.getVip()) {
                ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
                replacer.switchAndSetSceneSubscription(actionEvent, "/SubscriptionedVipPage2.fxml");
            } else {
                ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
                replacer.switchAndSetSceneSubscription(actionEvent, "/SubscriptionVipPage2.fxml");
            }
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    @FXML
    private void goToCheckRequestsPage(ActionEvent actionEvent) {
        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneCheckPendingRequests(actionEvent, "/CheckRequestsPage2.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    @FXML
    private void logout(ActionEvent actionEvent) {

        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to logout?");

        try {
            if (alert.showAndWait().get() == ButtonType.OK) {
                ReplaceScene.replaceScene(actionEvent, "/Welcome2.fxml");
                MySqlConnection.closeConnection();
                LoggedUserBean1.deleteInstance();
                LoggedClubOwnerBean1.deleteInstance();
                FileUtils.cleanDirectory(new File("eventImgs"));
                FileUtils.cleanDirectory(new File("profileImgs"));

            }
        } catch (SQLException | IOException e) {
            SystemException ex = new SystemException();
            ex.initCause(e);
            MyNotification.createNotification(ex);
        }
    }
    @FXML
    public void goToHome(ActionEvent actionEvent) {

        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/UserPage2.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

}
