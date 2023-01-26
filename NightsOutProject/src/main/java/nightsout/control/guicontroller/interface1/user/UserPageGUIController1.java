package nightsout.control.guicontroller.interface1.user;

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
import nightsout.utils.bean.IdBean;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.engineering.NextEventsEngineering;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.GenericBeanList;
import nightsout.utils.observer.Observer;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class UserPageGUIController1 implements Observer, Initializable {

    @FXML
    private Label labelName;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelSurname;
    @FXML
    private Label labelBirthday;
    @FXML
    private Label labelVip;
    @FXML
    private ListView<Pane> listViewNextEvents;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelGender;
    @FXML
    private ImageView profileImg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        NextEventsEngineering nextEventsEngineering;
        UserBean1 userBean1 = new UserBean1(Session.getInstance().getUser());
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

        try {
            nextEventsEngineering = new NextEventsEngineering();
            GenericBeanList list= new GenericBeanList(this);
            list.addEventsToList(nextEventsEngineering.searchNextEventsByIdUser(new IdBean(userBean1.getId())));
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
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
                ErrorDialog.getInstance().handleException(e);
            }
        }
    }
}
