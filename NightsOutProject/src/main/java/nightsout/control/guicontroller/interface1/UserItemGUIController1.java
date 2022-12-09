package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.LoggedClubOwnerBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

public class UserItemGUIController1 {

    private UserBean userBean;
    private ClubOwnerBean clubOwnerBean;
    @FXML
    Label labelType;
    @FXML
    Label labelUsername;
    @FXML
    ImageView imageViewProfilePic;

    public void setAll(UserBean userBean) {

        this.userBean = userBean;
        labelUsername.setText(this.userBean.getUsername());
        labelType.setText("USER");
        imageViewProfilePic.setImage(new Image(this.userBean.getImg().toURI().toString()));
    }

    public void setAll(ClubOwnerBean clubOwnerBean) {

        this.clubOwnerBean = clubOwnerBean;
        labelUsername.setText(this.clubOwnerBean.getUsername());
        labelType.setText("CLUB OWNER");
        imageViewProfilePic.setImage(new Image(this.clubOwnerBean.getImg().toURI().toString()));
    }

    @FXML
    private void goToProfile(ActionEvent actionEvent) {

        try {
            String type = LoggedClubOwnerBean.checkInstanceType();
            if (clubOwnerBean != null) {
                ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
                replacer.switchAndSetSceneViewClubOwnerPageFromUser(actionEvent, "/ViewClubOwnerPageFromUser1.fxml", clubOwnerBean);
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
