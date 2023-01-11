package nightsout.control.guicontroller.interface2.user;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.control.appcontroller.MakeReviewAppController;
import nightsout.control.guicontroller.interface2.item.EventItemGUIController2;
import nightsout.control.guicontroller.interface2.item.EventReviewItemGUIController2;
import nightsout.control.guicontroller.interface2.item.RequestsItemGUIController2;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.LoggedBean;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.engineering.CheckRequestsEngineering;
import nightsout.utils.engineering.ReviewEngineering;
import nightsout.utils.exception.ExceptionHandler;
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
    ListView listViewToReview;
    @FXML
    ListView listViewNextEvents;
    @FXML
    ListView listViewDeclined;
    @FXML
    ListView listViewPending;

    private void handleRequest(RequestBean rBean) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        try {
            if(Objects.equals(rBean.getStatus(), "accepted")){
                EventBean2 eventBean= new EventBean2(JoinEventAppController.searchEventByIdEvent(rBean.getIdEvent()));
                if(eventBean.getEventDate().isAfter(LocalDate.now())){
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource(REQUEST_ITEM_FXML)).openStream());
                    RequestsItemGUIController2 controller = fxmlLoader.getController();
                    controller.setAll(rBean);
                    this.listViewNextEvents.getItems().add(pane);
                }
            } else if (Objects.equals(rBean.getStatus(), "declined")) {

                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource(REQUEST_ITEM_FXML)).openStream());
                RequestsItemGUIController2 controller = fxmlLoader.getController();
                controller.setAll(rBean);
                this.listViewDeclined.getItems().add(pane);
            } else if (Objects.equals(rBean.getStatus(), "pending")) {

                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource(REQUEST_ITEM_FXML)).openStream());
                RequestsItemGUIController2 controller = fxmlLoader.getController();
                controller.setAll(rBean);
                this.listViewPending.getItems().add(pane);
            }
        } catch (SystemException | IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    private void handleEvent(EventBean eBean) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        ReviewBean reviewBean = null;

        try {
            reviewBean= MakeReviewAppController.getReviewByIdEventAndIdUser( userBean.getId(), eBean.getIdEvent());
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
            ExceptionHandler.handleException(e);
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
        this.userBean = new UserBean2(LoggedBean.getInstance().getUser());
        try {
            CheckRequestsEngineering.checkRequests(this, this.userBean.getId());
            ReviewEngineering.eventsToReview(this, userBean.getId());
        } catch (SystemException e) {
            ExceptionHandler.handleException(e);
        }
    }
}
