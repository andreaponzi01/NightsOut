package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.utils.observer.engineering.CreatedEventsEngineering;
import nightsout.utils.observer.Observer;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.scene.ReplaceScene;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ClubOwnerPageGUIController1 implements Observer {

    private ClubOwnerBean loggedClubOwner;

    @FXML
    private Label usernameLabel;

    @FXML
    private ListView listViewCreatedEvents;

    public void setLabelUserName(String username) { this.usernameLabel.setText(username); }

    @FXML
    public void goToCreateEventPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneCreateEvent(actionEvent, "/CreateEventPage1.fxml", loggedClubOwner);
    }

    @FXML
    public void goToManageRequestsPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneManageRequest(actionEvent, "/ManageRequests1.fxml", loggedClubOwner);
    }

    public void setAll(ClubOwnerBean clubOwnerBean) throws SQLException {
        loggedClubOwner = clubOwnerBean;
        setLabelUserName(clubOwnerBean.getUsername());
        CreatedEventsEngineering.createdEvents(this, clubOwnerBean.getId());

    }


    @FXML
    private void logout(ActionEvent actionEvent) throws SQLException {
        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to logout?: ");

        if(alert.showAndWait().get() == ButtonType.OK) {
            ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml");
            MySqlConnection.closeConnection();
        }
    }

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if(ob instanceof EventBean eBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/CreatedEventItem1.fxml")).openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            CreatedEventItemGUIController1 controller = fxmlLoader.getController();
            controller.setAll(loggedClubOwner, eBean, "/ClubOwnerPage1.fxml");
            this.listViewCreatedEvents.getItems().add(pane);
        }
    }

    public void goToResponsePage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneReviewResponse(actionEvent, "/ReviewResponsePage1.fxml", loggedClubOwner);
    }

    @FXML
    public void goToReviewsPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneReviewAndResponse(actionEvent, "/ReviewAndResponsePage1.fxml", loggedClubOwner);
        //replacer.switchAndSetSceneReviewAndResponse(actionEvent, "/ReviewAndResponsePage1.fxml", loggedClubOwner,userBean); dovrò passargli anche l' utente per poi tornare indietro
    }

    /*
    // PROVA DECORATOR
    @FXML
    private void goToDecoratedPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replaceSceneDynamic1 = new ReplaceSceneDynamic1();
        replaceSceneDynamic1.switchAndSetSceneDecorator(actionEvent, "/DecoratedPage1.fxml", loggedClubOwner);
    }
     */
}


