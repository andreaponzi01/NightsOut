package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import nightsout.utils.Observer;
import nightsout.utils.SearchEngineering;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scenes.ReplaceSceneDynamic1;

import java.io.IOException;

public class SearchPageGUIController1 implements Observer {

    @FXML
    private UserBean userBean;

    @FXML
    private TextField textFieldSearch;

    @FXML
    private ListView listView;

    public void setAll(UserBean userBean) {
        this.userBean = userBean;
    }

    @FXML
    private void backToUserPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml", userBean, null);
    }

    @FXML
    private void search() {
        String input = textFieldSearch.getText();
        this.listView.getItems().clear();
        if(!input.isBlank())
            SearchEngineering.search(this, input);
    }

    @Override
    public void update(Object object) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane pane = null;

        if(object instanceof UserBean userBean) {
            try {
                pane = fxmlLoader.load(getClass().getResource("/UserItem1.fxml").openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            UserItemGUIController1 controller = fxmlLoader.getController();
            controller.setAll(userBean);

            this.listView.getItems().add(pane);
        }

        if(object instanceof EventBean eventBean) {
            try {
                pane = fxmlLoader.load(getClass().getResource("/EventItem1.fxml").openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            EventItemGUIController1 controller = fxmlLoader.getController();
            //EventItemGUIController1 controller = new EventItemGUIController1();  che cambia se faccio cosi? non funziona ma perhce?
            controller.setAll(eventBean);

            this.listView.getItems().add(pane);
        }
    }
/*
    @Override
    public void updateFrom(Object ob, Object from) {}
 */
}
