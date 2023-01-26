package nightsout.control.guicontroller.interface2.item;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.ResponseBean;

public class ResponseItemGUIController2 {

    @FXML
    private Label labelResponse;
    @FXML
    private Label labelName;


    public void setAll(ResponseBean responseBean) {
        this.labelResponse.setText(responseBean.getResponse());
    }

    public void setAllCommunity(ResponseBean responseBean, ClubOwnerBean clubOwnerBean) {

        this.labelName.setText("Answer from " + clubOwnerBean.getUsername() + ":");
        this.labelResponse.setText(responseBean.getResponse());
    }
}
