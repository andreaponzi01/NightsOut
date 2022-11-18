package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.utils.NextEventsEngineering;
import nightsout.utils.Observer;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.scene.ReplaceScene;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class UserGUIController1 implements Observer {

    @FXML
    protected Label labelUsername;
    @FXML
    protected Label labelName;
    @FXML
    protected Label labelBirthday;
    @FXML
    protected Label labelVip;

    protected UserBean userBean;

    @FXML
    private ListView listViewNextEvents;


    public void setAll(UserBean userBean) throws SQLException {
        this.userBean = userBean;
        //this.labelUsername.setText(userBean.getUsername());
        this.labelName.setText(userBean.getName());
        this.labelVip.setText(String.valueOf(userBean.getVip()));
       // this.labelBirthday.setText(userBean.getBirthday());
        NextEventsEngineering.nextEvents(this, userBean.getId());
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
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/NextEventItem1.fxml")).openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            NextEventItemGUIController1 controller = fxmlLoader.getController();
            controller.setAll(userBean, eBean);
            this.listViewNextEvents.getItems().add(pane);
        }
    }

    public void goToBack(ActionEvent actionEvent) {

    }
}
