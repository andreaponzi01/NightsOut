package nightsout.control.guicontroller.interface1.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.utils.bean.LoggedBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage1;

public class UserItemGUIController1 {

    private UserBean1 userBean1;
    private ClubOwnerBean1 clubOwnerBean1;
    @FXML
    Label labelType;
    @FXML
    Label labelUsername;
    @FXML
    ImageView imageViewProfilePic;

    public void setAll(UserBean1 userBean1) {

        this.userBean1 = userBean1;
        labelUsername.setText(this.userBean1.getUsername());
        labelType.setText("USER");
        imageViewProfilePic.setImage(new Image(this.userBean1.getImg().toURI().toString()));
    }

    public void setAll(ClubOwnerBean1 clubOwnerBean1) {

        this.clubOwnerBean1 = clubOwnerBean1;
        labelUsername.setText(this.clubOwnerBean1.getUsername());
        labelType.setText("CLUB OWNER");
        imageViewProfilePic.setImage(new Image(this.clubOwnerBean1.getImg().toURI().toString()));
    }

    @FXML
    private void goToProfile(ActionEvent actionEvent) {

        try {
            String type = LoggedBean.getInstance().checkInstanceType();
            if (clubOwnerBean1 != null) {
                SwitchAndSetPage1.switchAndSetSceneClubOwner(actionEvent, "/ViewClubOwnerPageFromUser1.fxml", this.clubOwnerBean1);
            } else {
                if (type.equalsIgnoreCase("Free")) {
                    SwitchAndSetPage1.switchAndSetSceneUser(actionEvent, "/ViewUserPageFromUser1.fxml", this.userBean1);
                } else {
                    SwitchAndSetPage1.switchAndSetSceneUser(actionEvent, "/ViewUserPageFromCO1.fxml", this.userBean1);
                }
            }
        } catch (SystemException e) {
            ExceptionHandler.handleException(e);
        }
    }
}
