package nightsout.control.guicontroller.interface2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.EndedBookedEventsAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.control.guicontroller.interface2.Item.EventItemGUIController2;
import nightsout.control.guicontroller.interface2.Item.EventReviewItemGUIController2;
import nightsout.control.guicontroller.interface2.Item.RequestsItemGUIController2;
import nightsout.utils.bean.*;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.CheckRequestsEngineering;
import nightsout.utils.observer.engineering.ReviewEngineering;

import java.io.IOException;
import java.util.Objects;

public class CheckRequestsAndReviewGUIController2 implements Observer {
    private UserBean2 userBean;
    @FXML
    ListView listViewToReview;
    @FXML
    ListView listViewNextEvents;
    @FXML
    ListView listViewDeclined;
    @FXML
    ListView listViewPending;

    public void setAll() throws SystemException {
        this.userBean = LoggedUserBean2.getInstance();
        CheckRequestsEngineering.checkRequests(this, this.userBean.getId());
        ReviewEngineering.eventsToReview(this, userBean.getId());
        System.out.println("\n"+LoggedUserBean2.getInstance().getId());
    }

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        ReviewBean reviewBean=null;
        if (ob instanceof RequestBean rBean) {
            System.out.println("\n"+rBean.getStatus());
            if(Objects.equals(rBean.getStatus(), "accepted")){
                try {
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/CheckRequestsItem2.fxml")).openStream());
                    RequestsItemGUIController2 controller = fxmlLoader.getController();
                    controller.setAll(rBean);
                    this.listViewNextEvents.getItems().add(pane);
                } catch (SystemException | IOException e) {
                    MyNotification.createNotification(e);
                }
            } else if (Objects.equals(rBean.getStatus(), "declined")) {
                try {
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/CheckRequestsItem2.fxml")).openStream());
                    RequestsItemGUIController2 controller = fxmlLoader.getController();
                    controller.setAll(rBean);
                    System.out.println("\n"+rBean.getIdEvent());
                    this.listViewDeclined.getItems().add(pane);
                } catch (SystemException | IOException e) {
                    MyNotification.createNotification(e);
                }
            } else if (Objects.equals(rBean.getStatus(), "pending")) {
                try {
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/CheckRequestsItem2.fxml")).openStream());
                    RequestsItemGUIController2 controller = fxmlLoader.getController();
                    controller.setAll(rBean);
                    this.listViewPending.getItems().add(pane);
                } catch (SystemException | IOException e) {
                    MyNotification.createNotification(e);
                }
            }
        }//fine requestBean

        if(ob instanceof EventBean eBean) {
            try {
                reviewBean= EndedBookedEventsAppController.getReviewByIdEventAndIdUser( userBean.getId(), eBean.getIdEvent());
                if(reviewBean != null){
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem2.fxml")).openStream());
                    EventItemGUIController2 controller = fxmlLoader.getController();
                    controller.setAll(new EventBean2(eBean));
                    this.listViewToReview.getItems().add(pane);
                } else {
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventReviewItem2.fxml")).openStream());
                    EventReviewItemGUIController2 controller = fxmlLoader.getController();
                    controller.setAll(new EventBean2(eBean));
                    this.listViewToReview.getItems().add(pane);
                }
            } catch (SystemException | IOException e) {
                MyNotification.createNotification(e);
            }
        }
    }
}
