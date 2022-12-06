package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.bean.LoggedClubOwnerBean;
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
    private Label labelName;
    @FXML
    private Label labelWebsite;
    @FXML
    private Label labelAddress;
    @FXML
    private Label labelDiscountVip;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelCity;
    @FXML
    private Label labelUsername;
    @FXML
    private ListView listViewCreatedEvents;
    @FXML
    private MenuClubOwnerGUIController1 menuController;

    public void setAllCulo() throws SQLException, SystemException {
        loggedClubOwner = LoggedClubOwnerBean.getInstance();
        this.menuController.setAll();
        labelEmail.setText(loggedClubOwner.getEmail());
        labelUsername.setText(loggedClubOwner.getUsername());
        labelName.setText(loggedClubOwner.getName());
        labelAddress.setText(loggedClubOwner.getAddress());
        labelCity.setText(loggedClubOwner.getCity());
        labelDiscountVip.setText(String.valueOf(loggedClubOwner.getDiscountVIP()));
        CreatedEventsEngineering.createdEvents(this, loggedClubOwner.getId());
    }

    @Override
    public void update(Object ob) throws SQLException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if(ob instanceof EventBean eBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/NextEventItem1.fxml")).openStream());
            } catch (IOException e) {
                try {
                    ExceptionHandler.handleException(e);
                } catch (SystemException ex) {
                    MyNotification.createNotification(e);
                }
            }

            NextEventItemGUIController1 controller = fxmlLoader.getController();
            controller.setAll(eBean);
            this.listViewCreatedEvents.getItems().add(pane);
        }
    }
}


