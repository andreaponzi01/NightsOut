package nightsout.control.guicontroller.interface1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.NextEventsEngineering;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ViewUserPageFromUserGUIController1 implements Observer {

    @FXML
    protected Label labelUsername;
    @FXML
    protected Label labelName;
    @FXML
    protected Label labelBirthday;
    @FXML
    protected Label labelVip;
    @FXML
    protected Label labelGender;
    @FXML
    private Label labelSurname;
    @FXML
    private Label labelEmail;

    @FXML
    private ListView listViewNextEvents;
    @FXML
    private ImageView imageViewProfile;
    @FXML
    private MenuUserGUIController1 menuController;

    public void setAll(UserBean1 userBean1) {

        try {
            this.labelUsername.setText(userBean1.getUsername());
            this.labelEmail.setText(userBean1.getEmail());
            this.labelName.setText(userBean1.getName());
            this.labelSurname.setText(userBean1.getSurname());
            if (userBean1.getVip())
                this.labelVip.setText("VIP");
            else
                this.labelVip.setText("NO VIP");
            this.labelGender.setText(userBean1.getGender());
            this.labelBirthday.setText(userBean1.getBirthday().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
            this.imageViewProfile.setImage(new Image(userBean1.getImg().toURI().toString()));
            NextEventsEngineering.nextEvents(this, userBean1.getId());
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
                this.listViewNextEvents.getItems().add(pane);
            } catch (IOException e) {
                MyNotification.createNotification(e);
            }
        }
    }
}
