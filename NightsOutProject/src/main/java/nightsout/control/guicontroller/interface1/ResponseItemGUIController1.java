package nightsout.control.guicontroller.interface1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.ResponseBean;

public class ResponseItemGUIController1 {

    public ResponseItemGUIController1() {
        //ignore
    }

    @FXML
    private Label labelResponse;


    public void setAll(ResponseBean responseBean) {
        this.labelResponse.setText(responseBean.getResponse());
    }
}
