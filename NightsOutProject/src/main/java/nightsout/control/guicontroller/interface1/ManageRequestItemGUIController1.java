package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.ManageRequestBean;

import java.time.format.DateTimeFormatter;

public class ManageRequestItemGUIController1 {

    @FXML
    Label labelEventName;
    @FXML
    Label labelEventDate;
    @FXML
    Label labelUsername;

    @FXML
    public void acceptRequest(ActionEvent actionEvent) {
        // Da implementare
    }

    public void rejectRequest(ActionEvent actionEvent) {
        // Da implementare
    }

    public void setAll(ManageRequestBean manageRequestBean) {
        this.labelUsername.setText(manageRequestBean.getUserName() + " " + manageRequestBean.getUserSurname() );
        this.labelEventName.setText(String.valueOf(manageRequestBean.getEventName()));
        this.labelEventDate.setText(manageRequestBean.getRequestDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
    }

}
