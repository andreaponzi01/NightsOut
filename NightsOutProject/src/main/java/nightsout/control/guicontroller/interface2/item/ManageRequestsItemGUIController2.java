package nightsout.control.guicontroller.interface2.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.utils.Session;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.bean.interface2.ClubOwnerBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.SwitchAndSetPage2;
import nightsout.utils.scene.SwitchPage;

import java.time.format.DateTimeFormatter;

public class ManageRequestsItemGUIController2 {

    private ClubOwnerBean2 clubOwnerBean;
    private ManageRequestBean manageRequestBean;

    @FXML
    private Label labelEventName;
    @FXML
    private Label labelEventDate;
    @FXML
    private Label labelUsername;
    @FXML
    private ImageView imageViewProfile;
    private SwitchPage switchPage = new SwitchPage();
    private SwitchAndSetPage2 switchAndSetPage2 = new SwitchAndSetPage2();
    private JoinEventAppController joinEventAppController;


    public void setAll(ManageRequestBean manageRequestBean, JoinEventAppController joinEventAppController) {

        this.joinEventAppController = joinEventAppController;
        this.clubOwnerBean = new ClubOwnerBean2(Session.getInstance().getClubOwner());
        this.manageRequestBean=manageRequestBean;
        this.labelUsername.setText(manageRequestBean.getUsername());
        this.labelEventName.setText(String.valueOf(manageRequestBean.getEventName()));
        this.labelEventDate.setText(manageRequestBean.getRequestDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
        this.imageViewProfile.setImage(new Image(manageRequestBean.getImg().toURI().toString()));
    }
    @FXML
    public void acceptRequest(ActionEvent actionEvent) {

        try {
            joinEventAppController.acceptRequest(manageRequestBean.getIdRequest());
            switchPage.replaceScene(actionEvent,"/ClubOwnerPage2.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    public void rejectRequest(ActionEvent actionEvent) {

        try {
            joinEventAppController.declineRequest(manageRequestBean.getIdRequest());
            switchPage.replaceScene(actionEvent,"/ClubOwnerPage2.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    public void goToUserPage(ActionEvent actionEvent) {

        try {
            UserBean2 userBean = new UserBean2(joinEventAppController.searchUserByUsername(manageRequestBean.getUsername()));
            switchAndSetPage2.switchAndSetSceneUser(actionEvent, "/ViewUserPageFromCO2.fxml", userBean);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }


}
