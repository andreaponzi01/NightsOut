package nightsout.control.guicontroller.interface2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.control.guicontroller.interface2.Item.ReviewItemGUIController2;
import nightsout.utils.bean.LoggedClubOwnerBean2;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.ResponseEngineering;
import nightsout.utils.scene.switchPage.SwitchAndSetPage2;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ReviewsAndMakeResponsePageGUIController2 implements Initializable, Observer {

    @FXML
    ListView listViewReviews;

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if(ob instanceof ReviewBean reviewBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ReviewItem2.fxml")).openStream());
                ReviewItemGUIController2 controller = fxmlLoader.getController();
                controller.setAll(reviewBean);
                this.listViewReviews.getItems().add(pane);
            } catch (IOException | SystemException e) {
                MyNotification.createNotification(e);
            }
        }
    }

    public void goToCommunity(ActionEvent actionEvent) {

        try {
            SwitchAndSetPage2 replacer = new SwitchAndSetPage2();
            replacer.switchAndSetScene(actionEvent, "/CommunityPage2.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ResponseEngineering.eventReviews(this,  LoggedClubOwnerBean2.getInstance().getId());
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }
}
