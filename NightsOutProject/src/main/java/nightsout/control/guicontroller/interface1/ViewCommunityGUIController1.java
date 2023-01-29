package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.control.guicontroller.interface1.item.ResponseItemGUIController1;
import nightsout.control.guicontroller.interface1.item.ReviewItemGUIController1;
import nightsout.utils.Session;
import nightsout.utils.bean.IdBean;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.engineering.CommunityEngineering;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.switchpage.SwitchAndSetPage1;

import java.io.IOException;
import java.util.Objects;

public class ViewCommunityGUIController1 implements Observer {

    @FXML
    private ListView<Pane> listView;
    private ClubOwnerBean1 clubOwnerBean1;
    private SwitchAndSetPage1 switchAndSetPage1 = new SwitchAndSetPage1();

    private JoinEventAppController joinEventAppController;

    public void setAll(ClubOwnerBean1 clubOwnerBean1) throws SystemException {
        this.clubOwnerBean1 = clubOwnerBean1;
        CommunityEngineering communityEngineering = new CommunityEngineering();
        communityEngineering.eventReviews(this, new IdBean(this.clubOwnerBean1.getId()));
    }

    public void setAll(ClubOwnerBean1 clubOwnerBean1, JoinEventAppController joinEventAppController) throws SystemException {

        this.joinEventAppController = joinEventAppController;
        setAll(clubOwnerBean1);
    }

    @Override
    public void update(Object ob) {

        CommunityEngineering communityEngineering;
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;


        if(ob instanceof ResponseBean responseBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ResponseItem1.fxml")).openStream());

                ResponseItemGUIController1 controller = fxmlLoader.getController();
                controller.setAllCommunity(responseBean, this.clubOwnerBean1);
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }

        if (ob instanceof ReviewBean reviewBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/ReviewSimpleItem1.fxml")).openStream());
                communityEngineering = new CommunityEngineering();
                ReviewItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(reviewBean, joinEventAppController);
                this.listView.getItems().add(pane);
                communityEngineering.responseOfOneReview(this, new IdBean(reviewBean.getIdReview()));

            } catch (IOException | SystemException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
    }

    @FXML
    private void backToViewClubOwnerPage(ActionEvent actionEvent) {

        try {
            if(Session.getInstance().checkInstanceType().equalsIgnoreCase("Free"))
                switchAndSetPage1.switchAndSetSceneClubOwner(actionEvent, "/ViewClubOwnerPageFromUser1.fxml", this.clubOwnerBean1, joinEventAppController);
            else
                switchAndSetPage1.switchAndSetSceneClubOwner(actionEvent, "/ViewClubOwnerPageFromCO1.fxml", this.clubOwnerBean1);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
