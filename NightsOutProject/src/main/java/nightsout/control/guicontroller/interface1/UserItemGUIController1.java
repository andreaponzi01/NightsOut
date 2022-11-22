package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;

public class UserItemGUIController1 {

    private UserBean userBean;
    private ClubOwnerBean clubOwnerBean;
    private EventBean eventBean;
    private String oldFxml;

    @FXML
    Label labelType;
    @FXML
    Label labelUsername;

    public void setAll(UserBean userBean) {
        this.userBean = userBean;
        labelUsername.setText(this.userBean.getUsername());
        labelType.setText("USER");
    }

    public void setAll(UserBean userBean, ClubOwnerBean clubOwnerBean) {
        this.userBean = userBean;
        this.clubOwnerBean = clubOwnerBean;
        labelUsername.setText(this.clubOwnerBean.getUsername());
        labelType.setText("CLUB OWNER");
    }


    public void setAll(UserBean userBean, EventBean eventBean, String oldFxml) {
        this.userBean = userBean;
        this.eventBean = eventBean;
        this.oldFxml = oldFxml;
    }

    @FXML
    private void goToProfile(ActionEvent actionEvent) throws IOException, SQLException {
        if(clubOwnerBean == null) {
            //ATTENZIONE: PROVVISORIO
            //userBean.setType("Free");
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneViewUserPage(actionEvent,  userBean, eventBean, "/EventPageDecorator1.fxml", oldFxml);
        } else {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneViewClubOwnerPage(actionEvent, "/ViewClubOwnerPage1.fxml", userBean, clubOwnerBean, "/SearchPage1.fxml");
        }

    }

}
