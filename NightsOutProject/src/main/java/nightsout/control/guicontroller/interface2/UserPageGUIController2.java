package nightsout.control.guicontroller.interface2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.control.guicontroller.interface2.Item.EventItemGUIController2;
import nightsout.control.guicontroller.interface2.Item.UserItemGUIController2;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.bean.interface2.ClubOwnerBean2;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.SearchEngineering;

import java.io.IOException;
import java.util.Objects;

public class UserPageGUIController2 implements Observer {

    @FXML
    private ListView listView;
    @FXML
    private TextField textFieldSearch;

    @FXML
    private void search() {
        try {
            String input = textFieldSearch.getText();
            this.listView.getItems().clear();
            if (!input.isBlank())
                SearchEngineering.search(this, input);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    @Override
    public void update(Object ob) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if(ob instanceof UserBean uBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/UserItem2.fxml")).openStream());
                UserItemGUIController2 controller = fxmlLoader.getController();
                controller.setAll(new UserBean2(uBean));
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                MyNotification.createNotification(e);
            }
        }
        if(ob instanceof EventBean eBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem2.fxml")).openStream());
                EventItemGUIController2 controller = fxmlLoader.getController();
                controller.setAll(new EventBean2(eBean));
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                MyNotification.createNotification(e);
            }
        }
        if(ob instanceof ClubOwnerBean cBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/UserItem2.fxml")).openStream());
                UserItemGUIController2 controller = fxmlLoader.getController();
                controller.setAll(new ClubOwnerBean2(cBean));
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                MyNotification.createNotification(e);
            }
        }
    }
}
