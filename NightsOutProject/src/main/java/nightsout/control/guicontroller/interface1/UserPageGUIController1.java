package nightsout.control.guicontroller.interface1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.UserBean;

public class UserPageGUIController1 {

    @FXML
    protected Label usernameLabel;

    //protected UserBean userBean;
    public void setLabelUserName(String username) { this.usernameLabel.setText(username); }

    public void setAll(UserBean userBean) {

        //this.userBean = userBean;
        setLabelUserName(userBean.getUsername());
        //myStart();
    }

}
