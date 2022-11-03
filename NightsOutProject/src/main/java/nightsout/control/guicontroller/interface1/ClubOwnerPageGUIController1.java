package nightsout.control.guicontroller.interface1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.ClubOwnerBean;

public class ClubOwnerPageGUIController1 {

    @FXML
    private Label usernameLabel;

    public void setLabelUserName(String username) { this.usernameLabel.setText(username); }

    public void setAll(ClubOwnerBean clubOwnerBean) {

        setLabelUserName(clubOwnerBean.getUsername());

    }

}
