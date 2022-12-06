package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.bean.*;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;

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

    public void setAll( ClubOwnerBean clubOwnerBean) {
        this.clubOwnerBean = clubOwnerBean;
        labelUsername.setText(this.clubOwnerBean.getUsername());
        labelType.setText("CLUB OWNER");
    }

//sbagliapaola
    @FXML
    private void goToProfile(ActionEvent actionEvent) throws IOException, SQLException {
        try {
            String type = LoggedClubOwnerBean.checkInstanceType();
            if (clubOwnerBean != null) {
                ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
                replacer.switchAndSetSceneViewClubOwnerPage(actionEvent, "/ViewClubOwnerPage1.fxml", clubOwnerBean);
            } else {
                if (type.equals("FREE")) {
                    ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
                    replacer.switchAndSetSceneViewUserPageFromUser(actionEvent, "/ViewUserPageFromUser1.fxml", userBean);
                } else {
                    ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
                    replacer.switchAndSetSceneViewUserPageFromCO(actionEvent, "/ViewUserPageFromCO1.fxml", userBean);
                }
            }
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }

    }

}
