package nightsout.control.guicontroller.interface2.clubowner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.ManageReviewAppController;
import nightsout.control.guicontroller.interface2.item.ReviewItemToResponseGUIController2;
import nightsout.utils.Session;
import nightsout.utils.bean.IdBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.switchpage.SwitchPage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ReviewsAndMakeResponsePageGUIController2 implements Initializable, Observer {

    @FXML
    private ListView listViewReviews;
    private SwitchPage switchPage = new SwitchPage();
    private ManageReviewAppController manageReviewAppController = new ManageReviewAppController();

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if(ob instanceof ReviewBean reviewBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ReviewItemToResponse2.fxml")).openStream());
                ReviewItemToResponseGUIController2 controller = fxmlLoader.getController();
                controller.setAll(reviewBean, manageReviewAppController);
                this.listViewReviews.getItems().add(pane);
            } catch (IOException | SystemException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
    }

    @FXML
    private void goToCommunity(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent,"/CommunityPage2.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            manageReviewAppController.eventReviews(this,  new IdBean(Session.getInstance().getClubOwner().getId()));
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
