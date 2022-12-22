package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.CreatedEventsEngineering;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.util.Objects;

public class ViewClubOwnerPageFromUserGUIController1 implements Observer {

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
    private ListView listViewCreatedEvents;
    @FXML
    private ImageView imageViewProfile;

    private ClubOwnerBean1 clubOwnerBean1;

    public void setAll(ClubOwnerBean1 clubOwnerBean1) throws SystemException {

        this.clubOwnerBean1 = clubOwnerBean1;
        this.labelName.setText(clubOwnerBean1.getName());
        this.labelUsername.setText(clubOwnerBean1.getUsername());
        this.labelCity.setText(clubOwnerBean1.getCity());
        this.labelAddress.setText(clubOwnerBean1.getAddress());
        this.labelEmail.setText(clubOwnerBean1.getEmail());
        this.labelDiscountVip.setText(String.valueOf(clubOwnerBean1.getDiscountVIP())+"%");
        this.imageViewProfile.setImage(new Image(clubOwnerBean1.getImg().toURI().toString()));
        CreatedEventsEngineering.createdEvents(this, clubOwnerBean1.getId());
    }

    public void goToCommunity(ActionEvent actionEvent) {

        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneCommunityFromUser(actionEvent, "/ClubOwnerCommunityFromUser.fxml", this.clubOwnerBean1);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }

    }

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if(ob instanceof EventBean1 eBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem1.fxml")).openStream());
                EventItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(eBean);
                this.listViewCreatedEvents.getItems().add(pane);
            } catch (IOException e) {
                MyNotification.createNotification(e);
            }

        }
    }
}


