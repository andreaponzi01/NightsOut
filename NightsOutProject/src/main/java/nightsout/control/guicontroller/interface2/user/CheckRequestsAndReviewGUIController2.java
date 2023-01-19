package nightsout.control.guicontroller.interface2.user;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.CheckRequestAppController;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.control.appcontroller.ManageReviewAppController;
import nightsout.control.guicontroller.interface2.item.EventItemGUIController2;
import nightsout.control.guicontroller.interface2.item.EventReviewItemGUIController2;
import nightsout.control.guicontroller.interface2.item.RequestsItemGUIController2;
import nightsout.utils.Session;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class CheckRequestsAndReviewGUIController2 implements Observer, Initializable {
    private UserBean2 userBean;

    private static final String REQUEST_ITEM_FXML = "/CheckRequestsItem2.fxml";

    @FXML
    private ListView listViewToReview;
    @FXML
    private ListView listViewNextEvents;
    @FXML
    private ListView listViewDeclined;
    @FXML
    private ListView listViewPending;

    private void handleRequest(RequestBean rBean) {

        JoinEventAppController appController;
        RequestsItemGUIController2 controller;
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        try {
            appController = new JoinEventAppController();
            if(Objects.equals(rBean.getStatus(), "accepted")){
                EventBean2 eventBean= new EventBean2(appController.searchEventByIdEvent(rBean.getIdEvent()));
                if(eventBean.getEventDate().isAfter(LocalDate.now())){
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource(REQUEST_ITEM_FXML)).openStream());
                    controller = fxmlLoader.getController();
                    controller.setAll(rBean);
                    this.listViewNextEvents.getItems().add(pane);
                }
            } else if (Objects.equals(rBean.getStatus(), "declined")) {

                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource(REQUEST_ITEM_FXML)).openStream());
                controller = fxmlLoader.getController();
                controller.setAll(rBean);
                this.listViewDeclined.getItems().add(pane);
            } else if (Objects.equals(rBean.getStatus(), "pending")) {

                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource(REQUEST_ITEM_FXML)).openStream());
                controller = fxmlLoader.getController();
                controller.setAll(rBean);
                this.listViewPending.getItems().add(pane);
            }
        } catch (SystemException | IOException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    private void handleEvent(EventBean eBean) {
        
        ManageReviewAppController appController;

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        ReviewBean reviewBean = null;
        
        try {
            appController = new ManageReviewAppController();
            reviewBean = appController.getReviewByIdEventAndIdUser( userBean.getId(), eBean.getIdEvent());

            if(reviewBean != null){
                EventItemGUIController2 controller;
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem2.fxml")).openStream());
                controller = fxmlLoader.getController();
                controller.setAll(new EventBean2(eBean));
            } else {
                EventReviewItemGUIController2 controller;
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventReviewItem2.fxml")).openStream());
                controller = fxmlLoader.getController();
                controller.setAll(new EventBean2(eBean));
            }

            this.listViewToReview.getItems().add(pane);
        } catch (SystemException | IOException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @Override
    public void update(Object ob) {

        if (ob instanceof RequestBean rBean)
            handleRequest(rBean);

        if(ob instanceof EventBean eBean)
            handleEvent(eBean);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        CheckRequestAppController controller1;
        ManageReviewAppController controller2;
        this.userBean = new UserBean2(Session.getInstance().getUser());

        try {

            controller1 = new CheckRequestAppController();
            controller2 = new ManageReviewAppController();

            controller1.checkRequests(this, this.userBean.getId());
            controller2.eventsToReview(this, userBean.getId());
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
