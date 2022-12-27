package nightsout.control.guicontroller.interface1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.LoggedUserBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.NextEventsEngineering;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class UserPageGUIController1 implements Observer {

    @FXML
    protected Label labelName;
    @FXML
    protected Label labelEmail;
    @FXML
    protected Label labelSurname;
    @FXML
    protected Label labelBirthday;
    @FXML
    protected Label labelVip;

    protected UserBean1 userBean1;

    @FXML
    private ListView listViewNextEvents;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelGender;
    @FXML
    private ImageView profileImg;

    public void setAll() throws SystemException{
            this.userBean1 = LoggedUserBean1.getInstance();
            this.labelEmail.setText(userBean1.getEmail());
            this.labelUsername.setText(userBean1.getUsername());
            this.labelName.setText(userBean1.getName());
            this.labelSurname.setText(userBean1.getSurname());
            if (userBean1.getVip())
                this.labelVip.setText("VIP");
            else
                this.labelVip.setText("NO VIP");
            this.labelGender.setText(userBean1.getGender());
            this.labelBirthday.setText(userBean1.getBirthday().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
            profileImg.setImage(new Image(userBean1.getImg().toURI().toString()));
            NextEventsEngineering.nextEvents(this, userBean1.getId());
    }


    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if(ob instanceof EventBean eBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem1.fxml")).openStream());
                EventItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(new EventBean1(eBean));
                this.listViewNextEvents.getItems().add(pane);
            } catch (IOException e) {
                MyNotification.createNotification(e);
            }
        }
    }
}
