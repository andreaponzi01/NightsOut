package nightsout.control.guicontroller.interface1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import nightsout.utils.bean.RequestBean;

public class CheckRequestsItemGUIController1 {


    @FXML
    Label labelEventName;
    @FXML
    Label labelEventDate;
    @FXML
    Label labelUsername;
    @FXML
    Button buttonStatus;


    public void setAll(RequestBean requestBean){
        this.labelEventName.setText(String.valueOf(requestBean.getIdEvent()));
        this.buttonStatus.setText(requestBean.getStatus());
    }

}
