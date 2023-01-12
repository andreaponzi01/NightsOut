package nightsout.control.guicontroller.interface1.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import nightsout.control.appcontroller.SearchAppController;
import nightsout.control.guicontroller.interface1.item.EventItemGUIController1;
import nightsout.control.guicontroller.interface1.item.UserItemGUIController1;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.observer.Observer;
import nightsout.utils.scene.switchpage.SwitchPage;

import java.io.IOException;
import java.util.Objects;

public class SearchPageGUIController1 implements Observer {

    /*
        Subject: è colui che viene osservato. Nel caso specifico si tratta della nostra lista GenericBeanList
        L'osservato deve mantenere il riferimento ai propri osservatori, così da poterli notificare ogni
        volta che viene aggiornato lo stato dell'osservato.

        Observer: è colui che osserva. Nel caso specifica si tratta del SearchPageGUIController1, che
        quando riceve una notifica (cioè, ogni volta che viene aggiunto un User/Event Bean alla lista),
        aggiunge un Item (fxml) alla pagina.

        Creiamo l'oggetto Subject, aggiugendo sin da subito il riferimento all'observer chiamante, che ci
        passiamo alla chiamata della funzione search (cioè, SearchPageGUIController1).
    */

    @FXML
    private TextField textFieldSearch;
    @FXML
    private ListView listView;

    @FXML
    private void search() {
        try {
            String input = textFieldSearch.getText();
            this.listView.getItems().clear();
            if (!input.isBlank()) {
                //SearchEngineering.search(this, input);
                SearchAppController.search(this, input);
            }
        } catch (SystemException e) {
            ExceptionHandler.handleException(e);
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
                controller.setAll(new UserBean1(uBean));
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                ExceptionHandler.handleException(e);
            }
        }
        if(ob instanceof EventBean eBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/EventItem1.fxml")).openStream());
                EventItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(new EventBean1(eBean));
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                    ExceptionHandler.handleException(e);
                }
        }
        if(ob instanceof ClubOwnerBean cBean) {
            try {
                pane = fxmlLoader.load(Objects.requireNonNull(getClass().getResource("/UserItem1.fxml")).openStream());
                UserItemGUIController1 controller = fxmlLoader.getController();
                controller.setAll(new ClubOwnerBean1(cBean));
                this.listView.getItems().add(pane);
            } catch (IOException e) {
                ExceptionHandler.handleException(e);
            }
        }
    }
    @FXML
    public void backToUserPage(ActionEvent actionEvent) {
        SwitchPage.replaceScene(actionEvent,"/UserPage1.fxml");
    }
}
