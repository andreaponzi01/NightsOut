package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.utils.CreatedEventsEngineering;
import nightsout.utils.NextEventsEngineering;
import nightsout.utils.Observer;
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
    private void logout(ActionEvent actionEvent) throws IOException, SQLException {
        ReplaceScene.replaceScene(actionEvent, "/Welcome1.fxml");
        MySqlConnection.closeConnection();
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
            controller.setAll(loggedClubOwner, eBean);
            this.listViewCreatedEvents.getItems().add(pane);
        }
    }

    public void goToResponsePage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneReviewResponse(actionEvent, "/ReviewResponsePage1.fxml", loggedClubOwner);
    }
}
