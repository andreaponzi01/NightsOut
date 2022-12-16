package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.ReviewAndResponseEngineering;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.util.Objects;

public class ClubOwnerCommunityFromCOGUIController1 implements Observer {

    @FXML
    private ListView listView;

    private ClubOwnerBean clubOwnerBean;

    public void setAll(ClubOwnerBean clubOwnerBean) throws SystemException {
        this.clubOwnerBean = clubOwnerBean;
        ReviewAndResponseEngineering.eventReviews(this, this.clubOwnerBean.getId());
    }

    public void backToViewClubOwnerPage(ActionEvent actionEvent) {

        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneViewClubOwnerPageFromCO(actionEvent, "/ViewClubOwnerPageFromCO1.fxml", this.clubOwnerBean);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

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
                controller.setAllCommunity(responseBean, this.clubOwnerBean);
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                MyNotification.createNotification(e);
            }
        }
    }
}