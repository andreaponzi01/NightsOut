package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.LoggedClubOwnerBean1;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.ResponseEngineering;
import nightsout.utils.scene.switchPage.SwitchAndSetPage1;

import java.io.IOException;
import java.util.Objects;

public class EventReviewsClubOwnerGUIController1 implements Observer {

    @FXML
    ListView listViewReviews;

    public void setAll() throws SystemException {

        ResponseEngineering.eventReviews(this,  LoggedClubOwnerBean1.getInstance().getId());
    }

    public void backToClubOwnerPage(ActionEvent actionEvent) {

        try {
            SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
            replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage1.fxml");

        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    public void goToCommunity(ActionEvent actionEvent) {

        try {
            SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
            replacer.switchAndSetScene(actionEvent, "/ReviewAndResponsePage1.fxml");

        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if(ob instanceof ReviewBean reviewBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ReviewItem1.fxml")).openStream());
                ReviewItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(reviewBean);
                this.listViewReviews.getItems().add(pane);
            } catch (IOException | SystemException e) {
                MyNotification.createNotification(e);
            }
        }
    }
}
