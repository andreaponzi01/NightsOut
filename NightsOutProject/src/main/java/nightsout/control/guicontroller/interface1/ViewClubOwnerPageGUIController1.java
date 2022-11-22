package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.utils.observer.engineering.CreatedEventsEngineering;
import nightsout.utils.observer.Observer;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.scene.ReplaceScene;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ViewClubOwnerPageGUIController1 implements Observer {

    @FXML
    private Label labelName;
    @FXML
    private ListView listViewCreatedEvents;

    private ClubOwnerBean clubOwnerBean;
    private UserBean userBean;
    private String oldFxml;


    public void setLabelUserName(String name) { this.labelName.setText(name); }

    @FXML
    public void goToBack(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        System.out.println("Ehilà " + userBean.getUsername());
        if(oldFxml.equals("/SearchPage1.fxml"))
            replacer.switchAndSetSceneSearch(actionEvent, oldFxml, userBean);
        //Da completare
    }

    public void setAll(UserBean userBean, ClubOwnerBean clubOwnerBean, String oldFxml) throws SQLException {
        this.clubOwnerBean = clubOwnerBean;
        this.userBean = userBean;
        this.oldFxml = oldFxml;
        setLabelUserName(clubOwnerBean.getName());
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
            controller.setAll(clubOwnerBean, eBean);
            this.listViewCreatedEvents.getItems().add(pane);
        }
    }
}


