package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.interface1.item.ResponseItemGUIController1;
import nightsout.control.guicontroller.interface1.item.ReviewItemGUIController1;
import nightsout.utils.bean.LoggedBean;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.engineering.ReviewAndResponseEngineering;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.scene.switchpage.SwitchAndSetPage1;

import java.io.IOException;
import java.util.Objects;

public class ViewCommunityGUIController1 implements Observer {

    @FXML
    private ListView listView;

    private ClubOwnerBean1 clubOwnerBean1;

    public void setAll(ClubOwnerBean1 clubOwnerBean1) throws SystemException {
        this.clubOwnerBean1 = clubOwnerBean1;
        ReviewAndResponseEngineering.eventReviews(this, this.clubOwnerBean1.getId());
    }

    public void backToViewClubOwnerPage(ActionEvent actionEvent) {

        try {
            if(LoggedBean.getInstance().checkInstanceType().equalsIgnoreCase("Free"))
                SwitchAndSetPage1.switchAndSetSceneClubOwner(actionEvent, "/ViewClubOwnerPageFromUser1.fxml", this.clubOwnerBean1);
            else
                SwitchAndSetPage1.switchAndSetSceneClubOwner(actionEvent, "/ViewClubOwnerPageFromCO1.fxml", this.clubOwnerBean1);
        } catch (SystemException e) {
            ExceptionHandler.handleException(e);
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
                ExceptionHandler.handleException(e);
            }
        }


        if(ob instanceof ResponseBean responseBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ResponseItem1.fxml")).openStream());

                ResponseItemGUIController1 controller = fxmlLoader.getController();
                controller.setAllCommunity(responseBean, this.clubOwnerBean1);
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                ExceptionHandler.handleException(e);
            }
        }
    }
}
