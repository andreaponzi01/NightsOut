package nightsout.control.guicontroller.interface2.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.utils.bean.LoggedBean;
import nightsout.utils.bean.interface2.ClubOwnerBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage2;

public class UserItemGUIController2 {

    private UserBean2 userBean;
    private ClubOwnerBean2 clubOwnerBean;
    @FXML
    Label labelType;
    @FXML
    Label labelUsername;
    @FXML
    ImageView imageViewProfilePic;

    public void setAll(UserBean2 userBean) {

        this.userBean = userBean;
        labelUsername.setText(this.userBean.getUsername());
        labelType.setText("USER:");
        imageViewProfilePic.setImage(new Image(this.userBean.getImg().toURI().toString()));
    }

    public void setAll(ClubOwnerBean2 clubOwnerBean) {

        this.clubOwnerBean = clubOwnerBean;
        labelUsername.setText(this.clubOwnerBean.getUsername());
        labelType.setText("CLUB OWNER:");
        imageViewProfilePic.setImage(new Image(this.clubOwnerBean.getImg().toURI().toString()));
    }

    @FXML
    private void goToProfile(ActionEvent actionEvent) {

        try {
            String type = LoggedBean.getInstance().checkInstanceType();
            if (clubOwnerBean != null) {
                SwitchAndSetPage2.switchAndSetSceneCO(actionEvent, "/ViewCOPageFromUser2.fxml", clubOwnerBean);
            } else {
                if (type.equalsIgnoreCase("FREE")){
                    SwitchAndSetPage2.switchAndSetSceneUser(actionEvent, "/ViewUserPageFromUser2.fxml", userBean);
                } else {
                    SwitchAndSetPage2.switchAndSetSceneUser(actionEvent, "/ViewUserPageFromCO2.fxml", userBean);
                }
            }
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }
}
