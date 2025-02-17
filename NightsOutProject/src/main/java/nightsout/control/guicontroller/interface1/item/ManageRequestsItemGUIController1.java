package nightsout.control.guicontroller.interface1.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.utils.bean.IdBean;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.bean.UsernameBean;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchAndSetPage1;
import nightsout.utils.switchpage.SwitchPage;

import java.time.format.DateTimeFormatter;

public class ManageRequestsItemGUIController1 {

    private ManageRequestBean manageRequestBean;
    private SwitchPage switchPage = new SwitchPage();
    private SwitchAndSetPage1 switchAndSetPage1 = new SwitchAndSetPage1();
    @FXML
    private Label labelEventName;
    @FXML
    private Label labelEventDate;
    @FXML
    private Label labelUsername;
    @FXML
    private ImageView imageViewProfile;
    private JoinEventAppController joinEventAppController;

    public void setAll(ManageRequestBean manageRequestBean, JoinEventAppController joinEventAppController) {

        this.joinEventAppController = joinEventAppController;
        this.manageRequestBean = manageRequestBean;
        this.labelUsername.setText(manageRequestBean.getUsername());
        this.labelEventName.setText(String.valueOf(manageRequestBean.getEventName()));
        this.labelEventDate.setText(manageRequestBean.getRequestDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
        this.imageViewProfile.setImage(new Image(manageRequestBean.getImg().toURI().toString()));
    }

    @FXML
    private void acceptRequest(ActionEvent actionEvent) {

        try {
            joinEventAppController.acceptRequest(new IdBean(manageRequestBean.getIdRequest()));
            switchPage.replaceScene(actionEvent,"/ManageRequests1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void rejectRequest(ActionEvent actionEvent) {

        try {
            joinEventAppController.declineRequest(new IdBean(manageRequestBean.getIdRequest()));
            switchPage.replaceScene(actionEvent,"/ManageRequests1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void goToUserPage(ActionEvent actionEvent) {

        try {
            UserBean1 userBean = new UserBean1(joinEventAppController.searchUserByUsername(new UsernameBean(manageRequestBean.getUsername())));
            switchAndSetPage1.switchAndSetSceneUser(actionEvent, "/ViewUserPageFromCO1.fxml", userBean);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}