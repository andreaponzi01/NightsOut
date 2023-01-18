package nightsout.control.guicontroller.interface1.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.utils.Session;
import nightsout.utils.bean.ManageRequestBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchAndSetPage1;
import nightsout.utils.scene.switchpage.SwitchPage;

import java.time.format.DateTimeFormatter;

public class ManageRequestsItemGUIController1 {

    private ClubOwnerBean1 clubOwnerBean1;
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


    public void setAll(ManageRequestBean manageRequestBean) {

        this.clubOwnerBean1 = new ClubOwnerBean1(Session.getInstance().getClubOwner());
        this.manageRequestBean = manageRequestBean;
        this.labelUsername.setText(manageRequestBean.getUsername());
        this.labelEventName.setText(String.valueOf(manageRequestBean.getEventName()));
        this.labelEventDate.setText(manageRequestBean.getRequestDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
        this.imageViewProfile.setImage(new Image(manageRequestBean.getImg().toURI().toString()));
    }
    @FXML
    public void acceptRequest(ActionEvent actionEvent) {

        JoinEventAppController controller;

        try {
            controller = new JoinEventAppController();
            controller.acceptRequest(manageRequestBean.getIdRequest());
            switchPage.replaceScene(actionEvent,"/ManageRequests1.fxml");
        } catch (SystemException e) {
            ExceptionHandler.getInstance().handleException(e);
        }
    }

    public void rejectRequest(ActionEvent actionEvent) {

        JoinEventAppController controller;

        try {
            controller = new JoinEventAppController();
            controller.declineRequest(manageRequestBean.getIdRequest());
            switchPage.replaceScene(actionEvent,"/ManageRequests1.fxml");
        } catch (SystemException e) {
            ExceptionHandler.getInstance().handleException(e);
        }
    }

    public void goToUserPage(ActionEvent actionEvent) {

        JoinEventAppController controller;

        try {
            controller = new JoinEventAppController();
            UserBean1 userBean = new UserBean1(controller.searchUserByUsername(manageRequestBean.getUsername()));
            switchAndSetPage1.switchAndSetSceneUser(actionEvent, "/ViewUserPageFromCO1.fxml", userBean);
        } catch (SystemException e) {
            ExceptionHandler.getInstance().handleException(e);
        }
    }
}