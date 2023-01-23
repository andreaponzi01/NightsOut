package nightsout.control.guicontroller.interface1.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.ManageReviewAppController;
import nightsout.control.guicontroller.interface1.item.EventItemGUIController1;
import nightsout.control.guicontroller.interface1.item.EventReviewItemGUIController1;
import nightsout.utils.Session;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.switchpage.SwitchPage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class EndedBookedEventsGUIController1 implements Observer, Initializable {
    private UserBean1 userBean1;
    private SwitchPage switchPage = new SwitchPage();
    @FXML
    private ListView listViewEvents;
    private ManageReviewAppController manageReviewAppController = new ManageReviewAppController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ManageReviewAppController controller;
        this.userBean1 = new UserBean1(Session.getInstance().getUser());
        try {
            controller = new ManageReviewAppController();
            controller.eventsToReview(this, userBean1.getId());

        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    public void backToUserPage(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/UserPage1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        ReviewBean reviewBean=null;
        if(ob instanceof EventBean eBean) {
            try {
                reviewBean = manageReviewAppController.getReviewByIdEventAndIdUser(userBean1.getId(), eBean.getIdEvent());
                if(reviewBean != null){
                    EventItemGUIController1 controller;
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem1.fxml")).openStream());
                    controller = fxmlLoader.getController();
                    controller.setAll(new EventBean1(eBean));
                } else {
                    EventReviewItemGUIController1 controller;
                    pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventReviewItem1.fxml")).openStream());
                    controller = fxmlLoader.getController();
                    controller.setAll(new EventBean1(eBean), manageReviewAppController);
                }

                this.listViewEvents.getItems().add(pane);
            } catch (SystemException | IOException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
    }
}
