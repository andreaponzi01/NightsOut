package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;

public class ClubOwnerPageGUIController1 {

    private ClubOwnerBean loggedClubOwner;

    @FXML
    private Label usernameLabel;

    @FXML
    private Button buttonCreateEvent;

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

    public void setAll(ClubOwnerBean clubOwnerBean) {
        // Passaggio bean del club owner loggato
        loggedClubOwner = clubOwnerBean;
        // Settaggio informazioni "dinamiche"
        setLabelUserName(clubOwnerBean.getUsername());
    }

}
