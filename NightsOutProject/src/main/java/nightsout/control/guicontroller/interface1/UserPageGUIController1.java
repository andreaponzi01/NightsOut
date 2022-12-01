package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.LoggedUserBean;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.engineering.NextEventsEngineering;
import nightsout.utils.observer.Observer;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.db.MySqlConnection;
import nightsout.utils.scene.ReplaceScene;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class UserPageGUIController1 implements Observer {

    @FXML
    protected Label labelName;
    @FXML
    protected Label labelSurname;
    @FXML
    protected Label labelBirthday;
    @FXML
    protected Label labelVip;

    protected UserBean userBean;

    @FXML
    protected MenuUserGUIController1 menuController;
    @FXML
    private ListView listViewNextEvents;

    public void setAllCulo() throws SQLException {
        this.userBean = LoggedUserBean.getInstance();
        this.labelName.setText(userBean.getName());
        this.labelSurname.setText(userBean.getSurname());
        if(userBean.getVip())
            this.labelVip.setText("utente vip");
        else
            this.labelVip.setText("utente NON vip");
        this.labelBirthday.setText(userBean.getBirthday().toString());
        this.menuController.setAll();
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
                try {
                    ExceptionHandler.handleException(e);
                } catch (SystemException ex) {
                    MyNotification.createNotification(ex);
                }
            }

            NextEventItemGUIController1 controller = fxmlLoader.getController();
            controller.setAll(eBean);
            this.listViewNextEvents.getItems().add(pane);
        }
    }
}
