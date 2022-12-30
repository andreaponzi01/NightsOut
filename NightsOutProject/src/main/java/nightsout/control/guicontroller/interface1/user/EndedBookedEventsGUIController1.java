package nightsout.control.guicontroller.interface1.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.EndedBookedEventsAppController;
import nightsout.control.guicontroller.interface1.item.EventItemGUIController1;
import nightsout.control.guicontroller.interface1.item.EventReviewItemGUIController1;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.interface1.LoggedUserBean1;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.engineering.ReviewEngineering;
import nightsout.utils.scene.switchpage.SwitchPage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class EndedBookedEventsGUIController1 implements Observer, Initializable {
    private UserBean1 userBean1;
    @FXML
    ListView listViewEvents;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.userBean1 = LoggedUserBean1.getInstance();
        try {
            ReviewEngineering.eventsToReview(this, userBean1.getId());
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }

    @FXML
    public void backToUserPage(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent,"/UserPage1.fxml");}

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        ReviewBean reviewBean=null;

        if(ob instanceof EventBean eBean) {
            try {
                reviewBean= EndedBookedEventsAppController.getReviewByIdEventAndIdUser( userBean1.getId(), eBean.getIdEvent());
                if(reviewBean != null){
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem1.fxml")).openStream());
                    EventItemGUIController1 controller = fxmlLoader.getController();
                    controller.setAll(new EventBean1(eBean));
                    this.listViewEvents.getItems().add(pane);
                } else {
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventReviewItem1.fxml")).openStream());
                    EventReviewItemGUIController1 controller = fxmlLoader.getController();
                    controller.setAll(new EventBean1(eBean));
                    this.listViewEvents.getItems().add(pane);
                }
            } catch (SystemException | IOException e) {
                CreateNotification.createNotification(e);
            }
        }
    }
}
