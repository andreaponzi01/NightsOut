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
import nightsout.utils.scene.SwitchPage;

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

        System.out.println("\n\n\nprova1");
        ManageReviewAppController controller;
        this.userBean1 = new UserBean1(Session.getInstance().getUser());
        try {
            controller = new ManageReviewAppController();
            System.out.println("\n\n\nprova2");
            controller.eventsToReview(this, userBean1.getId());

        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
            e.printStackTrace();
        }
    }

    @FXML
    public void backToUserPage(ActionEvent actionEvent) {switchPage.replaceScene(actionEvent,"/UserPage1.fxml");}

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        ReviewBean reviewBean=null;
        System.out.println("\n\n\nprova3");
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
                System.out.println("\n\n\nprova4");
            } catch (SystemException | IOException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
        System.out.println("\n\n\nprova5");
    }
}
