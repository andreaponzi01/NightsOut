package nightsout.control.guicontroller.interface2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.appcontroller.ManageRequestsAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.LoggedClubOwnerBean2;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.bean.interface2.ClubOwnerBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;
import nightsout.utils.scene.ReplaceSceneDynamic2;

import java.time.format.DateTimeFormatter;

public class ManageRequestsItemGUIController2 {

    ClubOwnerBean2 clubOwnerBean;
    ManageRequestBean manageRequestBean;

    @FXML
    Label labelEventName;
    @FXML
    Label labelEventDate;
    @FXML
    Button buttonUsername;
    @FXML
    ImageView imageViewProfile;


    public void setAll(ManageRequestBean manageRequestBean) {

        this.clubOwnerBean= LoggedClubOwnerBean2.getInstance();
        this.manageRequestBean=manageRequestBean;
        this.buttonUsername.setText(manageRequestBean.getUsername());
        this.labelEventName.setText(String.valueOf(manageRequestBean.getEventName()));
        this.labelEventDate.setText(manageRequestBean.getRequestDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
        this.imageViewProfile.setImage(new Image(manageRequestBean.getImg().toURI().toString()));
    }
    @FXML
    public void acceptRequest(ActionEvent actionEvent) {

        try {
            ManageRequestsAppController.acceptRequest(manageRequestBean.getIdRequest());
            ReplaceSceneDynamic2 replacer = new ReplaceSceneDynamic2();
            replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage2.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    public void rejectRequest(ActionEvent actionEvent) {

        try {
            //appcontroller
            ManageRequestsAppController.declineRequest(manageRequestBean.getIdRequest());
            ReplaceSceneDynamic2 replacer = new ReplaceSceneDynamic2();
            replacer.switchAndSetScene(actionEvent, "/ClubOwnerPage2.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    public void goToUserPage(ActionEvent actionEvent) {

        try {
            UserBean2 userBean = new UserBean2(ManageRequestsAppController.searchUserByUsername(manageRequestBean.getUsername()));
            //ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            //replacer.switchAndSetSceneViewUserPageFromCO(actionEvent, "/.fxml", userBean);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }


}
