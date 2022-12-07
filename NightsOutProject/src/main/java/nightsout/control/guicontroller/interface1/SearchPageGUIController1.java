package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.LoggedUserBean;
import nightsout.utils.bean.UserBean;
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
    @FXML
    private MenuUserGUIController1 menuController;

    public void setAll() {

        LoggedUserBean.getInstance();
        this.menuController.setAll();
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

        if(ob instanceof UserBean uBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/UserItem1.fxml")).openStream());
                UserItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(uBean);
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                MyNotification.createNotification(e);
            }
        }

        if(ob instanceof EventBean eBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/NextEventItem1.fxml")).openStream());
                NextEventItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(eBean);
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                    MyNotification.createNotification(e);
                }

        }

        if(ob instanceof ClubOwnerBean cBean) {
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
