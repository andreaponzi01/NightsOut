package nightsout.control.guicontroller.interface1.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.LoggedClubOwnerBean1;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.bean.interface1.UserBean1;

import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage1;
import nightsout.utils.scene.switchpage.SwitchPage;

import java.time.format.DateTimeFormatter;

public class ManageRequestsItemGUIController1 {

    ClubOwnerBean1 clubOwnerBean1;
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

        this.clubOwnerBean1 = LoggedClubOwnerBean1.getInstance();
        this.manageRequestBean = manageRequestBean;
        this.buttonUsername.setText(manageRequestBean.getUsername());
        this.labelEventName.setText(String.valueOf(manageRequestBean.getEventName()));
        this.labelEventDate.setText(manageRequestBean.getRequestDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
        this.imageViewProfile.setImage(new Image(manageRequestBean.getImg().toURI().toString()));
    }
    @FXML
    public void acceptRequest(ActionEvent actionEvent) {

        try {
            JoinEventAppController.acceptRequest(manageRequestBean.getIdRequest());
            SwitchPage.replaceScene(actionEvent,"/ManageRequests1.fxml");
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }

    public void rejectRequest(ActionEvent actionEvent) {

        try {
            JoinEventAppController.declineRequest(manageRequestBean.getIdRequest());
            SwitchPage.replaceScene(actionEvent,"/ManageRequests1.fxml");
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }

    public void goToUserPage(ActionEvent actionEvent) {

        try {
            UserBean1 userBean = new UserBean1(JoinEventAppController.searchUserByUsername(manageRequestBean.getUsername()));
            SwitchAndSetPage1 replacer = new SwitchAndSetPage1();
            replacer.switchAndSetSceneUser(actionEvent, "/ViewUserPageFromCO1.fxml", userBean);
        } catch (SystemException e) {
            CreateNotification.createNotification(e);
        }
    }
}