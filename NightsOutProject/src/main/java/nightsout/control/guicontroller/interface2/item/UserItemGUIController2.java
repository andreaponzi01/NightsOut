package nightsout.control.guicontroller.interface2.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.utils.Session;
import nightsout.utils.bean.interface2.ClubOwnerBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchAndSetPage2;

public class UserItemGUIController2 {

    private UserBean2 userBean;
    private ClubOwnerBean2 clubOwnerBean;
    private SwitchAndSetPage2 switchAndSetPage2 = new SwitchAndSetPage2();
    @FXML
    private Label labelType;
    @FXML
    private Label labelUsername;
    @FXML
    private ImageView imageViewProfilePic;

    private JoinEventAppController joinEventAppController;

    public void setAll(UserBean2 userBean) {

        this.userBean = userBean;
        labelUsername.setText(this.userBean.getUsername());
        labelType.setText("USER:");
        imageViewProfilePic.setImage(new Image(this.userBean.getImg().toURI().toString()));
    }

    public void setAll(UserBean2 userBean, JoinEventAppController joinEventAppController) {
        this.joinEventAppController = joinEventAppController;
        setAll(userBean);
    }

    public void setAll(ClubOwnerBean2 clubOwnerBean) {

        this.clubOwnerBean = clubOwnerBean;
        labelUsername.setText(this.clubOwnerBean.getUsername());
        labelType.setText("CLUB OWNER:");
        imageViewProfilePic.setImage(new Image(this.clubOwnerBean.getImg().toURI().toString()));
    }

    public void setAll(ClubOwnerBean2 clubOwnerBean, JoinEventAppController joinEventAppController) {

        this.joinEventAppController = joinEventAppController;
        setAll(clubOwnerBean);
    }

    @FXML
    private void goToProfile(ActionEvent actionEvent) {

        try {
            String type = Session.getInstance().checkInstanceType();
            if (clubOwnerBean != null) {
                switchAndSetPage2.switchAndSetSceneCO(actionEvent, "/ViewCOPageFromUser2.fxml", clubOwnerBean, joinEventAppController);
            } else {
                if (type.equalsIgnoreCase("FREE")){
                    switchAndSetPage2.switchAndSetSceneUser(actionEvent, "/ViewUserPageFromUser2.fxml", userBean, joinEventAppController);
                } else {
                    switchAndSetPage2.switchAndSetSceneUser(actionEvent, "/ViewUserPageFromCO2.fxml", userBean);
                }
            }
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
