package nightsout.control.guicontroller.interface2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.control.guicontroller.interface1.EventItemGUIController1;
import nightsout.control.guicontroller.interface1.MenuClubOwnerGUIController1;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.LoggedClubOwnerBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.CreatedEventsEngineering;

import java.io.IOException;
import java.util.Objects;

public class ClubOwnerPageGUIController2 implements Observer {
    @FXML
    private Label labelName;
    @FXML
    private Label labelWebsite;
    @FXML
    private Label labelAddress;
    @FXML
    private Label labelDiscountVip;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelCity;
    @FXML
    private Label labelUsername;
    @FXML
    private ListView listViewCreatedEvents;
    @FXML
    private ImageView imageViewProfilePic;
    @FXML
    private MenuClubOwnerGUIController2 menuController;

    public void setAll() throws SystemException {

        LoggedClubOwnerBean loggedClubOwner = LoggedClubOwnerBean.getInstance();
        this.menuController.setAll();
        labelEmail.setText(loggedClubOwner.getEmail());
        labelUsername.setText(loggedClubOwner.getUsername());
        labelName.setText(loggedClubOwner.getName());
        labelAddress.setText(loggedClubOwner.getAddress());
        labelCity.setText(loggedClubOwner.getCity());
        labelDiscountVip.setText(String.valueOf(loggedClubOwner.getDiscountVIP()));
        CreatedEventsEngineering.createdEvents(this, loggedClubOwner.getId());
        imageViewProfilePic.setImage(new Image(loggedClubOwner.getImg().toURI().toString()));
    }

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if(ob instanceof EventBean eBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem1.fxml")).openStream());
                EventItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(eBean);
                this.listViewCreatedEvents.getItems().add(pane);
            }
            catch (IOException e) {
                MyNotification.createNotification(e);
            }
        }
    }
}


