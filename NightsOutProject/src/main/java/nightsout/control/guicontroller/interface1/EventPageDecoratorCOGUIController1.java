package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.EventPageDecoratorAppController;
import nightsout.utils.bean.*;
import nightsout.utils.decorator.*;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.EventParticipantsEngineering;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class EventPageDecoratorCOGUIController1 implements Observer {

    private ClubOwnerBean clubOwnerBean;
    private EventBean eventBean;

    @FXML
    private Label labelEventName;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelEventPrice;
    @FXML
    private Label labelEventDate;
    @FXML
    private Label labelEventTime;
    @FXML
    private Label labelEventDuration;
    @FXML
    private ListView listViewUsers;

    // Decorator
    @FXML
    private AnchorPane root;
    private ConcreteComponent myConcreteComponent;
    private VisualComponent contents;
    @FXML
    private MenuClubOwnerGUIController1 menuController;

    public void setAll( EventBean eventBean) throws SQLException {
        this.menuController.setAll();
        this.clubOwnerBean=LoggedClubOwnerBean.getInstance();
        this.eventBean = eventBean;
        this.labelUsername.setText(eventBean.getName());
        this.labelEventName.setText(eventBean.getName());
        this.labelEventPrice.setText(String.valueOf(eventBean.getPrice()));
        this.labelEventDate.setText(String.valueOf(eventBean.getEventDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy"))));
        this.labelEventDuration.setText(String.valueOf(eventBean.getDuration()));
        this.labelEventTime.setText(String.valueOf(LocalTime.of(eventBean.getHours(), eventBean.getMinutes()).toString()));
        EventParticipantsEngineering.eventParticipants(this, eventBean.getIdEvent());
        myStart();
    }

    private void myStart() throws SQLException {
        this.myConcreteComponent = new ConcreteComponent();
        //prendere lista di eventi se eventBean appartiene alla mia lista di eventi fare delete
        List<EventBean> list= EventPageDecoratorAppController.searchEventsByIdClubOwner(clubOwnerBean.getId());
        boolean isExists = list.contains(this.eventBean);
        System.out.println(isExists);
        if(!isExists){
            actionDecorateDelete();
        }
    }

    private void actionDecorateDelete(){
        ConcreteDecoratorDelete concreteDecoratorDelete = new ConcreteDecoratorDelete(this.myConcreteComponent, this.eventBean);
        this.contents = concreteDecoratorDelete;
        this.display();
    }

    public void display(){
        this.root.getChildren().add(this.contents.getButton());
    }

    @Override
    public void update(Object ob){

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if(ob instanceof UserBean userBean){
            try{
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/UserItem1.fxml")).openStream());
            }catch (IOException e){
                e.printStackTrace();
            }

            UserItemGUIController1 controller = fxmlLoader.getController();
            controller.setAll(userBean);
            this.listViewUsers.getItems().add(pane);

        }
    }
    @FXML
    public void goToMap(ActionEvent ae) throws SystemException {
        ReplaceSceneDynamic1 replacer= new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneMap(ae,"/MapPage1.fxml",eventBean);
    }
}
