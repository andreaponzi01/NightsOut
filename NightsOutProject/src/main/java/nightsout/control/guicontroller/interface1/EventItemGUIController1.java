package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.EventBean;

public class EventItemGUIController1 {

    private EventBean eventBean;

    @FXML
    Label labelEventName;

    @FXML
    private void goToEventPage(ActionEvent actionEvent) {
        System.out.println("(nome evento) "+eventBean.getName());
    }


    public void setAll(EventBean eventBean) {
        this.eventBean = eventBean;
        labelEventName.setText(this.eventBean.getName());
    }
}
