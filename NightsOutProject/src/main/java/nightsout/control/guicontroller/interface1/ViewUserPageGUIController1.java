package nightsout.control.guicontroller.interface1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.interface1.item.EventItemGUIController1;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.engineering.NextEventsEngineering;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ViewUserPageGUIController1 implements Observer {

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
    protected Label labelSurname;
    @FXML
    protected Label labelEmail;
    @FXML
    protected ListView listViewNextEvents;
    @FXML
    protected ImageView imageViewProfile;

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
            NextEventsEngineering nextEventsEngineering = new NextEventsEngineering();
            nextEventsEngineering.nextEvents(this, userBean1.getId());
        } catch (SystemException e) {
            ExceptionHandler.getInstance().handleException(e);
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
                controller.setAll(new EventBean1(eBean));
                this.listViewNextEvents.getItems().add(pane);
            } catch (IOException e) {
                ExceptionHandler.getInstance().handleException(e);
            }
        }
    }
}
