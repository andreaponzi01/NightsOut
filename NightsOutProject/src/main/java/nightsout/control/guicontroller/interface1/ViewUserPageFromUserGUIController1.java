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
import nightsout.utils.bean.UserBean;
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

    public void setAll(UserBean userBean) {

        try {
            this.menuController.setAll();
            this.labelUsername.setText(userBean.getUsername());
            this.labelEmail.setText(userBean.getEmail());
            this.labelName.setText(userBean.getName());
            this.labelSurname.setText(userBean.getSurname());
            if (userBean.getVip())
                this.labelVip.setText("VIP");
            else
                this.labelVip.setText("NO VIP");
            this.labelGender.setText(userBean.getGender());
            this.labelBirthday.setText(userBean.getBirthday().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
            this.imageViewProfile.setImage(new Image(userBean.getImg().toURI().toString()));
            NextEventsEngineering.nextEvents(this, userBean.getId());
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
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
                this.listViewNextEvents.getItems().add(pane);
            } catch (IOException e) {
                MyNotification.createNotification(e);
            }
        }
    }
}
