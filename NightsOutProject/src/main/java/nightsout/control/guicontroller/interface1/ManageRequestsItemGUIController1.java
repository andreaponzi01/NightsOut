package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import nightsout.control.appcontroller.ManageRequestsAppController;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.dao.UserDAO;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;
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

    @FXML
    public void acceptRequest(ActionEvent actionEvent) throws IOException, SQLException {

        ManageRequestsAppController.acceptRequest(manageRequestBean.getIdRequest());
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneManageRequest(actionEvent, "/ManageRequests1.fxml", clubOwnerBean);
    }

    public void rejectRequest(ActionEvent actionEvent) throws IOException, SQLException {
        //appcontroller
        ManageRequestsAppController.declineRequest(manageRequestBean.getIdRequest());
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneManageRequest(actionEvent, "/ManageRequests1.fxml", clubOwnerBean);
    }

    public void goToUserPage(ActionEvent actionEvent) throws IOException, SQLException {
        UserBean userBean =ManageRequestsAppController.searchUserByUsername(manageRequestBean.getUserName());
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetScene(actionEvent, "/ViewUserPage1.fxml", userBean ,null);
    }

    public void setAll(ManageRequestBean manageRequestBean,ClubOwnerBean clubOwnerBean) {
        this.clubOwnerBean=clubOwnerBean;
        this.manageRequestBean=manageRequestBean;
        this.buttonUsername.setText(manageRequestBean.getUserName() + " " + manageRequestBean.getUserSurname() );
        this.labelEventName.setText(String.valueOf(manageRequestBean.getEventName()));
        this.labelEventDate.setText(manageRequestBean.getRequestDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
    }

}
