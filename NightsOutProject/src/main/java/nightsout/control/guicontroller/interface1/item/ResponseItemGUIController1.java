package nightsout.control.guicontroller.interface1.item;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.ResponseBean;

public class ResponseItemGUIController1 {

    @FXML
    private Label labelResponse;
    @FXML
    private Label labelName;

    private ResponseItemGUIController1() {
        // ignored
    }

    public void setAll(ResponseBean responseBean) {
        this.labelResponse.setText(responseBean.getResponse());
    }

    public void setAllCommunity(ResponseBean responseBean, ClubOwnerBean1 clubOwnerBean1) {

        this.labelName.setText("Answer from " + clubOwnerBean1.getUsername() + ":");
        this.labelResponse.setText(responseBean.getResponse());
    }

}
