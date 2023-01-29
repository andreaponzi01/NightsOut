package nightsout.control.guicontroller.interface1.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.control.appcontroller.JoinEventAppController;
import nightsout.control.appcontroller.ManageReviewAppController;
import nightsout.utils.bean.EventBean;
import nightsout.utils.Session;
import nightsout.utils.bean.IdBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchAndSetPage1;
import nightsout.utils.switchpage.SwitchPage;

public class ReviewItemGUIController1 {


    private UserBean1 userBean1;
    private ReviewBean reviewBean;
    @FXML
    private Label labelComment;
    @FXML
    private Label labelEventName;
    @FXML
    private Label labelUsername;

    private SwitchAndSetPage1 switchAndSetPage1 = new SwitchAndSetPage1();
    private SwitchPage switchPage = new SwitchPage();
    private ManageReviewAppController manageReviewAppController;
    private JoinEventAppController joinEventAppController;

    public void setAll(ReviewBean reviewBean) throws SystemException {

        manageReviewAppController = new ManageReviewAppController();
        this.reviewBean = reviewBean;
        this.labelComment.setText(reviewBean.getComment());
        this.userBean1 = new UserBean1(manageReviewAppController.searchUserbyIdUser(new IdBean(reviewBean.getIdUser())));
        EventBean eventBean = manageReviewAppController.searchEventbyIdEvent(new IdBean(reviewBean.getIdEvent()));
        this.labelUsername.setText(userBean1.getUsername());
        this.labelEventName.setText(eventBean.getName());

    }


    public void setAll(ReviewBean reviewBean, JoinEventAppController joinEventAppController) throws SystemException {
        this.joinEventAppController = joinEventAppController;
        setAll(reviewBean);
    }

    public void setAll(ReviewBean reviewBean, ManageReviewAppController manageReviewAppController) throws SystemException {
        this.manageReviewAppController = manageReviewAppController;
        this.reviewBean = reviewBean;
        this.labelComment.setText(reviewBean.getComment());
        this.userBean1 = new UserBean1(manageReviewAppController.searchUserbyIdUser(new IdBean(reviewBean.getIdUser())));
        EventBean eventBean = manageReviewAppController.searchEventbyIdEvent(new IdBean(reviewBean.getIdEvent()));
        this.labelUsername.setText(userBean1.getUsername());
        this.labelEventName.setText(eventBean.getName());
    }
    @FXML
    private void goToResponsePage(ActionEvent actionEvent) {

        try {
            switchAndSetPage1.switchAndSetSceneMakeResponse(actionEvent, "/MakeResponsePage1.fxml", userBean1, reviewBean, manageReviewAppController);
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
    @FXML
    private void goToUserPage(ActionEvent actionEvent) {

        try {
            String type = Session.getInstance().checkInstanceType();
            if (type.equalsIgnoreCase("FREE")) {
                if(userBean1.getId()== Session.getInstance().getUser().getId())
                    switchPage.replaceScene(actionEvent,"/UserPage1.fxml");
                else
                    switchAndSetPage1.switchAndSetSceneUser(actionEvent,"/ViewUserPageFromUser1.fxml",userBean1, joinEventAppController);
            } else {
                switchAndSetPage1.switchAndSetSceneUser(actionEvent,"/ViewUserPageFromCO1.fxml",userBean1);
            }
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
