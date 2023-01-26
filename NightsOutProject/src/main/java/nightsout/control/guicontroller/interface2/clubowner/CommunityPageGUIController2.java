package nightsout.control.guicontroller.interface2.clubowner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.interface2.item.ResponseItemGUIController2;
import nightsout.control.guicontroller.interface2.item.ReviewItemGUIController2;
import nightsout.utils.Session;
import nightsout.utils.bean.IdBean;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.engineering.CommunityEngineering;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CommunityPageGUIController2 implements Initializable, Observer {

    @FXML
    private ListView<Pane> listView;

    @Override
    public void update(Object ob) {

        CommunityEngineering communityEngineering;
        Pane pane = null;
        FXMLLoader fxmlLoader = new FXMLLoader();

        if(ob instanceof ResponseBean responseBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ResponseItem2.fxml")).openStream());

                ResponseItemGUIController2 controller = fxmlLoader.getController();
                controller.setAll(responseBean);
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
        if (ob instanceof ReviewBean reviewBean) {
            try {
                communityEngineering = new CommunityEngineering();
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ReviewItem2.fxml")).openStream());
                ReviewItemGUIController2 controller = fxmlLoader.getController();
                controller.setAll(reviewBean);
                this.listView.getItems().add(pane);
                communityEngineering.responseOfOneReview(this, new IdBean(reviewBean.getIdReview()));
            } catch (IOException | SystemException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CommunityEngineering communityEngineering;
        try {
            communityEngineering = new CommunityEngineering();
            communityEngineering.eventReviews(this,  new IdBean(Session.getInstance().getClubOwner().getId()));
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
