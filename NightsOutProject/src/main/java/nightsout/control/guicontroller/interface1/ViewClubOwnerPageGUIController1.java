package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.control.guicontroller.interface1.item.EventItemGUIController1;
import nightsout.utils.Session;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.IdBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.engineering.ClubOwnerPageEngineering;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.switchpage.SwitchAndSetPage1;

import java.io.IOException;
import java.util.Objects;

public class ViewClubOwnerPageGUIController1 implements Observer {

    private ClubOwnerBean1 clubOwnerBean1;
    private SwitchAndSetPage1 switchAndSetPage1 = new SwitchAndSetPage1();
    @FXML
    private Label labelName;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelCity;
    @FXML
    private Label labelAddress;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelDiscountVip;
    @FXML
    private ListView<Pane> listViewCreatedEvents;
    @FXML
    private ImageView imageViewProfile;

    private JoinEventAppController joinEventAppController;


    public void setAll(ClubOwnerBean1 clubOwnerBean1) throws SystemException {

        this.clubOwnerBean1 = clubOwnerBean1;
        this.labelName.setText(clubOwnerBean1.getName());
        this.labelUsername.setText(clubOwnerBean1.getUsername());
        this.labelCity.setText(clubOwnerBean1.getCity());
        this.labelAddress.setText(clubOwnerBean1.getAddress());
        this.labelEmail.setText(clubOwnerBean1.getEmail());
        this.labelDiscountVip.setText(clubOwnerBean1.getDiscountVIP()+"%");
        this.imageViewProfile.setImage(new Image(clubOwnerBean1.getImg().toURI().toString()));
        ClubOwnerPageEngineering clubOwnerPageEngineering = new ClubOwnerPageEngineering();
        clubOwnerPageEngineering.createdEvents(this, new IdBean(clubOwnerBean1.getId()));
    }

    public void setAll(ClubOwnerBean1 clubOwnerBean1, JoinEventAppController joinEventAppController) throws SystemException {

        this.joinEventAppController= joinEventAppController;
        setAll(clubOwnerBean1);
    }

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if(ob instanceof EventBean eBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem1.fxml")).openStream());
                EventItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(new EventBean1(eBean),joinEventAppController);
                this.listViewCreatedEvents.getItems().add(pane);
            } catch (IOException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
    }

    @FXML
    private void goToCommunity(ActionEvent actionEvent) {

        try {
            if(Session.getInstance().checkInstanceType().equalsIgnoreCase("ClubOwner"))
                switchAndSetPage1.switchAndSetSceneClubOwner(actionEvent, "/ClubOwnerCommunityFromCO.fxml", this.clubOwnerBean1);
            else
                switchAndSetPage1.switchAndSetSceneClubOwner(actionEvent, "/ClubOwnerCommunityFromUser.fxml", this.clubOwnerBean1, joinEventAppController);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }


}


