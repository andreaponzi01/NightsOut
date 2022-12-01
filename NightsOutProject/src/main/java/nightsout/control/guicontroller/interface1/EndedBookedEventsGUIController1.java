package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.EndedBookedEventsAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.bean.LoggedUserBean;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.ReviewEngineering;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class EndedBookedEventsGUIController1 implements Observer {
    private UserBean userBean;

    @FXML
    ListView listViewEvents;
    @FXML
    private MenuUserGUIController1 menuController;


    public void setAll() throws SQLException {
        this.userBean = LoggedUserBean.getInstance();
        this.menuController.setAll();
        ReviewEngineering.endedBookedEvents(this, userBean.getId());
    }

    public void backToUserPage(ActionEvent actionEvent) throws IOException {
        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    @Override
    public void update(Object ob) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        ReviewBean reviewBean=null;

        if(ob instanceof EventBean eBean) {
            try {
                reviewBean= EndedBookedEventsAppController.getReviewByIdEventAndIdUser( userBean.getId(), eBean.getIdEvent());
                if(reviewBean!=null){
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem1.fxml")).openStream());
                    EventItemGUIController1 controller = fxmlLoader.getController();
                    controller.setAll( eBean);
                    this.listViewEvents.getItems().add(pane);
                } else {
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventReviewItem1.fxml")).openStream());
                    EventReviewItemGUIController1 controller = fxmlLoader.getController();
                    controller.setAll(eBean);
                    this.listViewEvents.getItems().add(pane);
                }

            } catch (IOException e) {
                try {
                    ExceptionHandler.handleException(e);
                } catch (SystemException ex) {
                    MyNotification.createNotification(ex);
                }
            } catch (SystemException e) {
                MyNotification.createNotification(e);
            }
        }
    }
}
