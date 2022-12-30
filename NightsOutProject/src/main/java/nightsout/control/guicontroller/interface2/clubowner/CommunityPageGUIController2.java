package nightsout.control.guicontroller.interface2.clubowner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.utils.exception.CreateNotification;
import nightsout.control.guicontroller.interface2.Item.ResponseItemGUIController2;
import nightsout.control.guicontroller.interface2.Item.ReviewItemGUIController2;
import nightsout.utils.bean.interface2.LoggedClubOwnerBean2;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.engineering.ReviewAndResponseEngineering;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CommunityPageGUIController2 implements Initializable, Observer {

    @FXML
    ListView listView;

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if (ob instanceof ReviewBean reviewBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ReviewItem2.fxml")).openStream());
                ReviewItemGUIController2 controller = fxmlLoader.getController();
                controller.setAll(reviewBean);
                this.listView.getItems().add(pane);
                ReviewAndResponseEngineering.responseOfOneReview(this, reviewBean.getIdReview());
            } catch (IOException | SystemException e) {
                CreateNotification.createNotification(e);
            }
        }

        if(ob instanceof ResponseBean responseBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ResponseItem2.fxml")).openStream());

                ResponseItemGUIController2 controller = fxmlLoader.getController();
                controller.setAll(responseBean);
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                CreateNotification.createNotification(e);
            }
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ReviewAndResponseEngineering.eventReviews(this,  LoggedClubOwnerBean2.getInstance().getId());
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }
}
