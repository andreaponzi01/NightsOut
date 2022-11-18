package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.control.appcontroller.RequestAppController;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.RequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.util.Objects;

public class UserItemGUIController1 {

    private UserBean userBean;
    private ClubOwnerBean clubOwnerBean;

    @FXML
    Label labelType;
    @FXML
    Label labelUsername;

    public void setAll(UserBean userBean) {
        this.userBean = userBean;
        labelUsername.setText(this.userBean.getUsername());
        labelType.setText("USER");
    }

    public void setAll(ClubOwnerBean clubOwnerBean) {
        this.clubOwnerBean = clubOwnerBean;
        labelUsername.setText(this.clubOwnerBean.getUsername());
        labelType.setText("CLUB OWNER");
    }


    //da completare perche cosi io cambio proprio utente mentre io devo vedere solo le info di un utente
    @FXML
    private void goToProfile(ActionEvent actionEvent) throws IOException {
        if(clubOwnerBean == null) {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/User1.fxml", userBean, null);
        } else{
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage1.fxml", null, clubOwnerBean);
        }

    }

}
