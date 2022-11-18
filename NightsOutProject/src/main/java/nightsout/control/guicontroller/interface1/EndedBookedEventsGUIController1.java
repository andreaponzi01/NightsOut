package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.utils.CheckRequestsEngineering;
import nightsout.utils.Observer;
import nightsout.utils.ReviewEngineering;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class EndedBookedEventsGUIController1 implements Observer {
    private UserBean userBean;

    @FXML
    ListView listViewEvents;


    public void setAll(UserBean userBean) throws SQLException {
        this.userBean = userBean;
        ReviewEngineering.endedBookedEvents(this, userBean.getId());
    }

    public void backToUserPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml", userBean, null);
    }

    @Override
    public void update(Object ob) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if(ob instanceof EventBean eBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventReviewItem1.fxml")).openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            EventReviewItemGUIController1 controller = fxmlLoader.getController();
            controller.setAll(userBean, eBean);
            this.listViewEvents.getItems().add(pane);
        }
    }
}
