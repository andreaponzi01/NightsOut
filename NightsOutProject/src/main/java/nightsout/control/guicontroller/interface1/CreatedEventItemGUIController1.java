package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.LoggedClubOwnerBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;

public class CreatedEventItemGUIController1 {

    private EventBean eventBean;
    @FXML
    Label labelEventName;

    public void setAll(EventBean eventBean) throws SQLException {
        this.eventBean=eventBean;
        labelEventName.setText(this.eventBean.getName());
    }

    public void goToEventPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneEventCO(actionEvent, "/EventPageDecoratorCO1.fxml", eventBean);
    }
}
