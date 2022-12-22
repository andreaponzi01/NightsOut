package nightsout.control.guicontroller.interface2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.control.guicontroller.interface1.ResponseItemGUIController1;
import nightsout.control.guicontroller.interface1.ReviewItemGUIController1;
import nightsout.utils.bean.LoggedClubOwnerBean2;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.ReviewAndResponseEngineering;

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
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ReviewSimpleItem1.fxml")).openStream());
                ReviewItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(reviewBean);
                this.listView.getItems().add(pane);
                ReviewAndResponseEngineering.responseOfOneReview(this, reviewBean.getIdReview());
            } catch (IOException | SystemException e) {
                MyNotification.createNotification(e);
            }
        }

        if(ob instanceof ResponseBean responseBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ResponseItem1.fxml")).openStream());

                ResponseItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(responseBean);
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                MyNotification.createNotification(e);
            }
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ReviewAndResponseEngineering.eventReviews(this,  LoggedClubOwnerBean2.getInstance().getId());
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }
}
