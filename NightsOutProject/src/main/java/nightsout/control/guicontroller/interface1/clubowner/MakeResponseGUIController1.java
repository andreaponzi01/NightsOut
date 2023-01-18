package nightsout.control.guicontroller.interface1.clubowner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import nightsout.control.appcontroller.ManageReviewAppController;
import nightsout.utils.Session;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchPage;

public class MakeResponseGUIController1 {
    @FXML
    private Label labelEventName;
    @FXML
    private Label labelUsername;
    @FXML
    private TextArea textAreaResponse;
    private ReviewBean reviewBean;

    private SwitchPage switchPage = new SwitchPage();

    public void setAll(UserBean1 userBean, ReviewBean reviewBean) throws SystemException {

        ManageReviewAppController controller = new ManageReviewAppController();
        this.reviewBean=reviewBean;
        this.labelUsername.setText(userBean.getUsername());
        this.labelEventName.setText(controller.searchEventbyIdEvent(reviewBean.getIdEvent()).getName());
    }
    public void createResponse(ActionEvent actionEvent) {

        ManageReviewAppController controller;

        try {
            controller = new ManageReviewAppController();
            ResponseBean responseBean = new ResponseBean();
            responseBean.setResponse(textAreaResponse.getText());
            responseBean.setIdClubOwner(Session.getInstance().getClubOwner().getId());
            responseBean.setReview(reviewBean.getIdReview());
            controller.makeResponse(responseBean);
            switchPage.replaceScene(actionEvent,"/ReviewsCOPage1.fxml");
        } catch (SystemException | EmptyInputException e) {
            ExceptionHandler.getInstance().handleException(e);
        }
    }
    public void backToReviewsPage(ActionEvent actionEvent) {switchPage.replaceScene(actionEvent,"/ReviewsCOPage1.fxml");}
}
