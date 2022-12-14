package nightsout.control.guicontroller.interface2.clubowner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.interface2.item.ResponseItemGUIController2;
import nightsout.control.guicontroller.interface2.item.ReviewItemGUIController2;
import nightsout.utils.bean.LoggedBean;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.engineering.ReviewAndResponseEngineering;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;

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
                ExceptionHandler.handleException(e);
            }
        }

        if(ob instanceof ResponseBean responseBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ResponseItem2.fxml")).openStream());

                ResponseItemGUIController2 controller = fxmlLoader.getController();
                controller.setAll(responseBean);
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                ExceptionHandler.handleException(e);
            }
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ReviewAndResponseEngineering.eventReviews(this,  LoggedBean.getInstance().getClubOwner().getId());
        } catch (SystemException e) {
            ExceptionHandler.handleException(e);
        }
    }
}
