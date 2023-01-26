package nightsout.control.guicontroller.interface1.clubowner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import nightsout.control.appcontroller.ManageReviewAppController;
import nightsout.utils.Session;
import nightsout.utils.bean.IdBean;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchPage;

public class MakeResponseGUIController1 {
    @FXML
    private Label labelEventName;
    @FXML
    private Label labelUsername;
    @FXML
    private TextArea textAreaResponse;
    private ReviewBean reviewBean;

    private SwitchPage switchPage = new SwitchPage();
    private ManageReviewAppController manageReviewAppController;

    public void setAll(ManageReviewAppController manageReviewAppController, UserBean1 userBean, ReviewBean reviewBean) throws SystemException {

        this.manageReviewAppController = manageReviewAppController;
        this.reviewBean=reviewBean;
        this.labelUsername.setText(userBean.getUsername());
        this.labelEventName.setText(manageReviewAppController.searchEventbyIdEvent(new IdBean(reviewBean.getIdEvent())).getName());
    }

    @FXML
    private void createResponse(ActionEvent actionEvent) {

        try {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setResponse(textAreaResponse.getText());
            responseBean.setIdClubOwner(Session.getInstance().getClubOwner().getId());
            responseBean.setReview(reviewBean.getIdReview());
            manageReviewAppController.makeResponse(responseBean);
            switchPage.replaceScene(actionEvent,"/ReviewsCOPage1.fxml");
        } catch (SystemException | EmptyInputException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    @FXML
    private void backToReviewsPage(ActionEvent actionEvent) {
        try {
            switchPage.replaceScene(actionEvent, "/ReviewsCOPage1.fxml");
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
