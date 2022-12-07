package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import nightsout.control.appcontroller.ManageRequestsAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.LoggedClubOwnerBean;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.time.format.DateTimeFormatter;

public class ManageRequestsItemGUIController1 {

    ClubOwnerBean clubOwnerBean;
    ManageRequestBean manageRequestBean;

    @FXML
    Label labelEventName;
    @FXML
    Label labelEventDate;
    @FXML
    Button buttonUsername;


    public void setAll(ManageRequestBean manageRequestBean) {

        this.clubOwnerBean= LoggedClubOwnerBean.getInstance();
        this.manageRequestBean=manageRequestBean;
        this.buttonUsername.setText(manageRequestBean.getUserName());
        this.labelEventName.setText(String.valueOf(manageRequestBean.getEventName()));
        this.labelEventDate.setText(manageRequestBean.getRequestDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
    }
    @FXML
    public void acceptRequest(ActionEvent actionEvent) {

        try {
            ManageRequestsAppController.acceptRequest(manageRequestBean.getIdRequest());
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneManageRequest(actionEvent, "/ManageRequests1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    public void rejectRequest(ActionEvent actionEvent) {

        try {
            //appcontroller
            ManageRequestsAppController.declineRequest(manageRequestBean.getIdRequest());
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneManageRequest(actionEvent, "/ManageRequests1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }

    public void goToUserPage(ActionEvent actionEvent) {

        try {
            UserBean userBean = ManageRequestsAppController.searchUserByUsername(manageRequestBean.getUserName());
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneViewUserPageFromCO(actionEvent, "/ViewUserPageFromCO1.fxml", userBean);
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }


}
