package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.ReviewAndResponseEngineering;
import nightsout.utils.bean.*;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ReviewAndResponseGUIController1 implements Observer {
    private ClubOwnerBean clubOwnerBean;

    @FXML
    ListView listView;


    public void setAll(ClubOwnerBean clubOwnerBean) throws SQLException {
        //da fare
        this.clubOwnerBean = clubOwnerBean;
        ReviewAndResponseEngineering.eventReviews(this, clubOwnerBean.getId());
    }

    public void backToUserPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage1.fxml", null, clubOwnerBean);
        //replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml", userBean, null); deve ritornare all'utente
    }

    @Override
    public void update(Object ob) throws SQLException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if(ob instanceof ReviewBean reviewBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ReviewSimpleItem1.fxml")).openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            ReviewItemGUIController1 controller = fxmlLoader.getController();
            controller.setAll(clubOwnerBean, reviewBean);
            this.listView.getItems().add(pane);
            ReviewAndResponseEngineering.ResponseOfOneReview(this,reviewBean.getIdReview());
        }

        if(ob instanceof ResponseBean responseBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ResponseItem1.fxml")).openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            ResponseItemGUIController1 controller = fxmlLoader.getController();
            controller.setAll(clubOwnerBean, responseBean);
            this.listView.getItems().add(pane);
        }
    }

}
