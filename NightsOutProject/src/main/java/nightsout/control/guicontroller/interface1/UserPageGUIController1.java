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
import nightsout.utils.bean.LoggedUserBean;
import nightsout.utils.bean.UserBean;
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

    protected UserBean userBean;

    @FXML
    protected MenuUserGUIController1 menuController;
    @FXML
    private ListView listViewNextEvents;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelGender;
    @FXML
    private ImageView profileImg;

    public void setAll() {
        try {
            this.userBean = LoggedUserBean.getInstance();
            this.menuController.setAll();
            this.labelEmail.setText(userBean.getEmail());
            this.labelUsername.setText(userBean.getUsername());
            this.labelName.setText(userBean.getName());
            this.labelSurname.setText(userBean.getSurname());
            if (userBean.getVip())
                this.labelVip.setText("VIP");
            else
                this.labelVip.setText("NO VIP");
            this.labelGender.setText(userBean.getGender());
            this.labelBirthday.setText(userBean.getBirthday().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
            profileImg.setImage(new Image(userBean.getImg().toURI().toString()));
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
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/NextEventItem1.fxml")).openStream());
                NextEventItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(eBean);
                this.listViewNextEvents.getItems().add(pane);
            } catch (IOException e) {
                MyNotification.createNotification(e);
            }
        }
    }
}
