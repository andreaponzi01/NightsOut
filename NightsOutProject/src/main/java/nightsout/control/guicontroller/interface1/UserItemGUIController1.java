package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.UserBean;

public class UserItemGUIController1 {

    private UserBean userBean;

    @FXML
    Label labelUsername;

    @FXML
    private void goToProfile(ActionEvent actionEvent) {
        System.out.println("()");
    }

    public void setAll(UserBean userBean) {
        this.userBean = userBean;
        labelUsername.setText(this.userBean.getUsername());
    }

}
