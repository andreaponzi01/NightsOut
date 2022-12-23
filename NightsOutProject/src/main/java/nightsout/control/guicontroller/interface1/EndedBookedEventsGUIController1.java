package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.EndedBookedEventsAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.LoggedUserBean1;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.ReviewEngineering;
import nightsout.utils.scene.switchPage.SwitchAndSetPage1;

import java.io.IOException;
import java.util.Objects;

public class EndedBookedEventsGUIController1 implements Observer {
    private UserBean1 userBean1;

    @FXML
    ListView listViewEvents;
    @FXML
    private MenuUserGUIController1 menuController;


    public void setAll() throws SystemException {
        this.userBean1 = LoggedUserBean1.getInstance();
        ReviewEngineering.eventsToReview(this, userBean1.getId());
    }

    public void backToUserPage(ActionEvent actionEvent) {

        try {
            SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
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

        if(ob instanceof EventBean1 eBean) {
            try {
                reviewBean= EndedBookedEventsAppController.getReviewByIdEventAndIdUser( userBean1.getId(), eBean.getIdEvent());
                if(reviewBean != null){
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem1.fxml")).openStream());
                    EventItemGUIController1 controller = fxmlLoader.getController();
                    controller.setAll(eBean);
                    this.listViewEvents.getItems().add(pane);
                } else {
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventReviewItem1.fxml")).openStream());
                    EventReviewItemGUIController1 controller = fxmlLoader.getController();
                    controller.setAll(eBean);
                    this.listViewEvents.getItems().add(pane);
                }
            } catch (SystemException | IOException e) {
                MyNotification.createNotification(e);
            }
        }
    }
}
