package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import nightsout.utils.Observer;
import nightsout.utils.SearchEngineering;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scenes.ReplaceSceneDynamic1;

import java.io.IOException;

public class SearchPageGUIController1 implements Observer {

    @FXML
    private UserBean userBean;

    @FXML
    private TextField textFieldSearch;

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
        SearchEngineering.search(this, input);
    }

    // Poiché il "nuovo" Observer è un'interfaccia
    @Override
    public void update(Object ob) {}

    @Override
    public void updateFrom(Object ob, Object from) {}
}
