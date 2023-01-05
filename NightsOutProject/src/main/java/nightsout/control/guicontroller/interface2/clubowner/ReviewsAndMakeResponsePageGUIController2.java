package nightsout.control.guicontroller.interface2.clubowner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.utils.exception.CreateNotification;
import nightsout.control.guicontroller.interface2.item.ReviewItemGUIController2;
import nightsout.utils.bean.interface2.LoggedClubOwnerBean2;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.engineering.ResponseEngineering;
import nightsout.utils.scene.switchpage.SwitchPage;

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
                CreateNotification.createNotification(e);
            }
        }
    }

    public void goToCommunity(ActionEvent actionEvent) {
            SwitchPage.replaceScene(actionEvent,"/CommunityPage2.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ResponseEngineering.eventReviews(this,  LoggedClubOwnerBean2.getInstance().getId());
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }
}
