package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.UserBean;

public class UserItemGUIController1 {

    private UserBean userBean;
    private ClubOwnerBean clubOwnerBean;

    @FXML
    Label labelType;
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

    public void setAll(ClubOwnerBean clubOwnerBean) {
        this.clubOwnerBean = clubOwnerBean;
        labelUsername.setText(this.clubOwnerBean.getUsername());
        labelType.setText("CLUB OWNER");
    }

}
