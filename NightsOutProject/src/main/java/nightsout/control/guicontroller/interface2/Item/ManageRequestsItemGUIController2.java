package nightsout.control.guicontroller.interface2.Item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.interface2.LoggedClubOwnerBean2;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.bean.interface2.ClubOwnerBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage2;
import nightsout.utils.scene.switchpage.SwitchPage;

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
            JoinEventAppController.acceptRequest(manageRequestBean.getIdRequest());
            SwitchPage.replaceScene(actionEvent,"/ClubOwnerPage2.fxml");
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }

    public void rejectRequest(ActionEvent actionEvent) {

        try {
            JoinEventAppController.declineRequest(manageRequestBean.getIdRequest());
            SwitchPage.replaceScene(actionEvent,"/ClubOwnerPage2.fxml");
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }

    public void goToUserPage(ActionEvent actionEvent) {

        try {
            UserBean2 userBean = new UserBean2(JoinEventAppController.searchUserByUsername(manageRequestBean.getUsername()));
            SwitchAndSetPage2 replacer = new SwitchAndSetPage2();
            replacer.switchAndSetSceneUser(actionEvent, "/ViewUserPageFromCO2.fxml", userBean);
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }


}
