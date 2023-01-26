package nightsout.control.guicontroller.interface1.clubowner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.interface1.item.EventItemGUIController1;
import nightsout.utils.Session;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.engineering.ClubOwnerPageEngineering;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ClubOwnerPageGUIController1 implements Observer, Initializable {
    @FXML
    private Label labelName;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ClubOwnerBean1 loggedClubOwner = new ClubOwnerBean1(Session.getInstance().getClubOwner());
        labelEmail.setText(loggedClubOwner.getEmail());
        labelUsername.setText(loggedClubOwner.getUsername());
        labelName.setText(loggedClubOwner.getName());
        labelAddress.setText(loggedClubOwner.getAddress());
        labelCity.setText(loggedClubOwner.getCity());
        labelDiscountVip.setText(String.valueOf(loggedClubOwner.getDiscountVIP()));
        try {
            ClubOwnerPageEngineering clubOwnerPageEngineering = new ClubOwnerPageEngineering();
            clubOwnerPageEngineering.createdEvents(this, loggedClubOwner.getId());
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
        imageViewProfilePic.setImage(new Image(loggedClubOwner.getImg().toURI().toString()));
    }
    @Override
    public void update(Object ob) {

        Pane pane = null;
        FXMLLoader fxmlLoader = new FXMLLoader();
        if(ob instanceof EventBean eBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem1.fxml")).openStream());
                EventItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(new EventBean1(eBean));
                this.listViewCreatedEvents.getItems().add(pane);
            }
            catch (IOException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
    }
}


