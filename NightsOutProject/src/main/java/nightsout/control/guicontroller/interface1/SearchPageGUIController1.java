package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.LoggedUserBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.observer.engineering.SearchEngineering;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.util.Objects;

public class SearchPageGUIController1 implements Observer {

    @FXML
    private TextField textFieldSearch;
    @FXML
    private ListView listView;

    public void setAll() {

        LoggedUserBean1.getInstance();
    }

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

        if(ob instanceof UserBean1 uBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/UserItem1.fxml")).openStream());
                UserItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(uBean);
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                MyNotification.createNotification(e);
            }
        }

        if(ob instanceof EventBean1 eBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem1.fxml")).openStream());
                EventItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(eBean);
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                    MyNotification.createNotification(e);
                }

        }

        if(ob instanceof ClubOwnerBean1 cBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/UserItem1.fxml")).openStream());
                UserItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(cBean);
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                MyNotification.createNotification(e);
            }
        }
    }

    @FXML
    public void backToUserPage(ActionEvent actionEvent) {

        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }
}
