package nightsout.control.guicontroller.interface1.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.control.guicontroller.interface1.item.EventItemGUIController1;
import nightsout.control.guicontroller.interface1.item.UserItemGUIController1;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.SearchBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.switchpage.SwitchPage;

import java.io.IOException;
import java.util.Objects;

public class SearchPageGUIController1 implements Observer {

    @FXML
    private TextField textFieldSearch;
    @FXML
    private ListView<Pane> listView;

    private SwitchPage switchPage = new SwitchPage();

    private JoinEventAppController joinEventAppController = new JoinEventAppController();


    @FXML
    private void search() {


        try {
            joinEventAppController = new JoinEventAppController();
            String input = textFieldSearch.getText();
            this.listView.getItems().clear();
            if (!input.isBlank()) {
                SearchBean searchBean = new SearchBean(input);
                joinEventAppController.search(this, searchBean);
            }
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
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
                controller.setAll(new UserBean1(uBean), joinEventAppController);
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
        if(ob instanceof EventBean eBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem1.fxml")).openStream());
                EventItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(new EventBean1(eBean), joinEventAppController);
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                    ErrorDialog.getInstance().handleException(e);
            }
        }
        if(ob instanceof ClubOwnerBean cBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/UserItem1.fxml")).openStream());
                UserItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(new ClubOwnerBean1(cBean), joinEventAppController);
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                ErrorDialog.getInstance().handleException(e);
            }
        }
    }
    @FXML
    private void backToUserPage(ActionEvent actionEvent) {
        try {
        switchPage.replaceScene(actionEvent,"/UserPage1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
