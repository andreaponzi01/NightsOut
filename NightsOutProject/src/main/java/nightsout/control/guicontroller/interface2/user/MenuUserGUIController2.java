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
import nightsout.utils.Session;
import nightsout.utils.bean.interface2.UserBean2;
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
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

public class MenuUserGUIController2 implements Initializable {

    private UserBean2 userBean;
    @FXML
    private Button buttonVip;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelCognome;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelBirthday;
    @FXML
    private Label labelNome;
    @FXML
    private Circle circleProfile;
    private SwitchPage switchPage = new SwitchPage();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.userBean = new UserBean2(Session.getInstance().getUser());
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
            try {
                switchPage.replaceScene(actionEvent,"/SubscriptionVipPage2.fxml");
            } catch (SystemException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
    }

    @FXML
    private void goToCheckRequestsPage(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/CheckRequestsAndReviewPage2.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void logout(ActionEvent actionEvent) {

        Optional<ButtonType> optional;
        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to logout?");
        try {
            optional = alert.showAndWait();
            if (optional.isEmpty()) {
                throw new AlertNotFoundException();
            }
            ButtonType value = optional.get();
            if (value == ButtonType.OK) {
                switchPage.replaceScene(actionEvent, "/Welcome2.fxml");
                MySqlConnection.getInstance().closeConnection();
                Session.getInstance().deleteSession();
                FileUtils.cleanDirectory(new File("eventImgs"));
                FileUtils.cleanDirectory(new File("profileImgs"));
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
    private void goToHome(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/UserPage2.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
