package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
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
    private Label labelUsername;
    @FXML
    private Label labelCity;
    @FXML
    private Label labelAddress;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelDiscountVip;
    @FXML
    private ListView listViewCreatedEvents;
    private ClubOwnerBean clubOwnerBean;
    @FXML
    private MenuUserGUIController1 menuController;

    public void setAll(ClubOwnerBean clubOwnerBean) throws SQLException, SystemException {
        this.clubOwnerBean = clubOwnerBean;
        this.menuController.setAll();
        this.labelName.setText(clubOwnerBean.getName());
        this.labelUsername.setText(clubOwnerBean.getUsername());
        this.labelCity.setText(clubOwnerBean.getCity());
        this.labelAddress.setText(clubOwnerBean.getAddress());
        this.labelEmail.setText(clubOwnerBean.getEmail());
        this.labelDiscountVip.setText(String.valueOf(clubOwnerBean.getDiscountVIP()));

        CreatedEventsEngineering.createdEvents(this, clubOwnerBean.getId());
    }

    @Override
    public void update(Object ob) {

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


