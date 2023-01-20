package nightsout.control.guicontroller.interface1.clubowner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.interface1.item.ResponseItemGUIController1;
import nightsout.control.guicontroller.interface1.item.ReviewItemGUIController1;
import nightsout.utils.Session;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.engineering.CommunityEngineering;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.scene.SwitchPage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MyCommunityPageGUIController1 implements Observer, Initializable {
    @FXML
    private ListView listView;
    private SwitchPage switchPage = new SwitchPage();

    @FXML
    public void backToReviewsPage(ActionEvent actionEvent) {switchPage.replaceScene(actionEvent,"/ReviewsCOPage1.fxml");}

    @Override
    public void update(Object ob) {

        CommunityEngineering communityEngineering;
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if (ob instanceof ReviewBean reviewBean) {
            try {
                communityEngineering = new CommunityEngineering();
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ReviewSimpleItem1.fxml")).openStream());
                ReviewItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(reviewBean);
                this.listView.getItems().add(pane);
                communityEngineering.responseOfOneReview(this, reviewBean.getIdReview());
            } catch (IOException | SystemException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
        if(ob instanceof ResponseBean responseBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ResponseItem1.fxml")).openStream());
                ResponseItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(responseBean);
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ClubOwnerBean1 clubOwnerBean1 = new ClubOwnerBean1(Session.getInstance().getClubOwner());
        CommunityEngineering communityEngineering;
        try {
            communityEngineering = new CommunityEngineering();
            communityEngineering.eventReviews(this, clubOwnerBean1.getId());
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

}
