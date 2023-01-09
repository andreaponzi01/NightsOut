package nightsout.control.guicontroller.interface2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.interface2.item.EventItemGUIController2;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.engineering.NextEventsEngineering;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ViewUserPageGUIController2 implements Observer {

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

    public void setAll(UserBean2 userBean) {

        try {
            this.labelUsername.setText(userBean.getUsername());
            this.labelEmail.setText(userBean.getEmail());
            this.labelName.setText(userBean.getName());
            this.labelSurname.setText(userBean.getSurname());
            if (userBean.getVip())
                this.labelVip.setText("IS VIP");
            else
                this.labelVip.setText("IS NOT VIP");
            this.labelGender.setText(userBean.getGender());
            this.labelBirthday.setText(userBean.getBirthday().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
            this.imageViewProfile.setImage(new Image(userBean.getImg().toURI().toString()));
            NextEventsEngineering.nextEvents(this, userBean.getId());
        } catch (SystemException e) {
            ExceptionHandler.handleException(e);
        }
    }

    @Override
    public void update(Object ob) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;
        if(ob instanceof EventBean eBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem2.fxml")).openStream());
                EventItemGUIController2 controller = fxmlLoader.getController();
                controller.setAll(new EventBean2(eBean));
                this.listViewNextEvents.getItems().add(pane);
            } catch (IOException e) {
                ExceptionHandler.handleException(e);
            }
        }
    }
}
