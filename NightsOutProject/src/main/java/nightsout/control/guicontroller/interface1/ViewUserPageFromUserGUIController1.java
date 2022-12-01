package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.utils.bean.LoggedClubOwnerBean;
import nightsout.utils.observer.engineering.NextEventsEngineering;
import nightsout.utils.observer.Observer;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ViewUserPageFromUserGUIController1 implements Observer {

    @FXML
    protected Label labelUsername;
    @FXML
    protected Label labelName;
    @FXML
    protected Label labelBirthday;
    @FXML
    protected Label labelVip;

    private UserBean userBean;

    @FXML
    private ListView listViewNextEvents;
    @FXML
    private MenuUserGUIController1 menuController;
    @FXML
    private Label labelSurname;


    public void setAll(UserBean userBean) throws SQLException {
        this.menuController.setAll();
        this.userBean = userBean;
        this.labelUsername.setText(userBean.getUsername());
        this.labelName.setText(userBean.getName());
        this.labelSurname.setText(userBean.getSurname());
        if(userBean.getVip())
            this.labelVip.setText("utente vip");
        else
            this.labelVip.setText("utente NON vip");
        this.labelBirthday.setText(userBean.getBirthday().toString());
        NextEventsEngineering.nextEvents(this, userBean.getId());
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
            controller.setAll(eBean);
            this.listViewNextEvents.getItems().add(pane);
        }
    }
}
