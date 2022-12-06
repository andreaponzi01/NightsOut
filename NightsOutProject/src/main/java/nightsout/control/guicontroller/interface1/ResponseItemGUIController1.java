package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import nightsout.control.appcontroller.EventReviewsClubOwnerAppController;
import nightsout.utils.bean.*;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;

public class ResponseItemGUIController1 {

    public ResponseItemGUIController1() {
        //ignore
    }

    @FXML
    private Label labelResponse;


    public void setAll(ResponseBean responseBean) throws SQLException {
        this.labelResponse.setText(responseBean.getResponse());
    }
}
