package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import nightsout.control.appcontroller.EventReviewsClubOwnerAppController;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;

public class ResponseItemGUIController1 {

    public ResponseItemGUIController1() {
        //ignore
    }

    @FXML
    private TextArea textAreaResponse;
    @FXML
    private Label labelUsername; //renderlo bottone

    public void setAll(ClubOwnerBean clubOwnerBean, ResponseBean responseBean) throws SQLException {
        this.textAreaResponse.setText(responseBean.getResponse());
        this.labelUsername.setText(String.valueOf(clubOwnerBean.getId()));
        //implementare di vedere il nome e non l' id del clubOwner
    }
}
