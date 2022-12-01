package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
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
    @FXML
    private MenuClubOwnerGUIController1 menuController;

    public void setAll() throws SQLException {
        this.clubOwnerBean = LoggedClubOwnerBean.getInstance();
        this.menuController.setAll();
        ReviewAndResponseEngineering.eventReviews(this, clubOwnerBean.getId());
    }

    public void backToUserPage(ActionEvent actionEvent) throws IOException {
          try {
              ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
              replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage1.fxml");
          } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    @Override
    public void update(Object ob) throws SQLException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if(ob instanceof ReviewBean reviewBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ReviewSimpleItem1.fxml")).openStream());
            } catch (IOException e) {
                try {
                    ExceptionHandler.handleException(e);
                } catch (SystemException ex) {
                    MyNotification.createNotification(e);
                }
            }
            ReviewItemGUIController1 controller = fxmlLoader.getController();
            controller.setAll(reviewBean);
            this.listView.getItems().add(pane);
            ReviewAndResponseEngineering.ResponseOfOneReview(this,reviewBean.getIdReview());
        }

        if(ob instanceof ResponseBean responseBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ResponseItem1.fxml")).openStream());
            } catch (IOException e) {
                try {
                    ExceptionHandler.handleException(e);
                } catch (SystemException ex) {
                    MyNotification.createNotification(e);
                }
            }
            ResponseItemGUIController1 controller = fxmlLoader.getController();
            controller.setAll(responseBean);
            this.listView.getItems().add(pane);
        }
    }

}
