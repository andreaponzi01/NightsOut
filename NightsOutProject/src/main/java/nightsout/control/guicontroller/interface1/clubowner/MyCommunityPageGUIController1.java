package nightsout.control.guicontroller.interface1.clubowner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.interface1.item.ResponseItemGUIController1;
import nightsout.control.guicontroller.interface1.item.ReviewItemGUIController1;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.LoggedClubOwnerBean1;
import nightsout.utils.engineering.ReviewAndResponseEngineering;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.scene.switchpage.SwitchPage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MyCommunityPageGUIController1 implements Observer, Initializable {
    @FXML
    ListView listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ClubOwnerBean1 clubOwnerBean1 = LoggedClubOwnerBean1.getInstance();
        try {
            ReviewAndResponseEngineering.eventReviews(this, clubOwnerBean1.getId());
        } catch (SystemException e) {
            //CreateNotification.createNotification(e);
            ExceptionHandler.handleException(e);
        }
    }
    @FXML
    public void backToReviewsPage(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent,"/ReviewResponsePage1.fxml");}

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
                CreateNotification.createNotification(e);
            }
        }
        if(ob instanceof ResponseBean responseBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ResponseItem1.fxml")).openStream());

                ResponseItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(responseBean);
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                CreateNotification.createNotification(e);
            }
        }
    }
}
