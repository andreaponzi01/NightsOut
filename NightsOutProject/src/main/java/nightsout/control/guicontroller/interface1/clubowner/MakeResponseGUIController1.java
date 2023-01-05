package nightsout.control.guicontroller.interface1.clubowner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import nightsout.control.appcontroller.MakeResponseAppController;
import nightsout.utils.exception.CreateNotification;
import nightsout.utils.bean.interface1.LoggedClubOwnerBean1;
import nightsout.utils.bean.ResponseBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.switchpage.SwitchPage;

public class MakeResponseGUIController1 {
    private ClubOwnerBean1 clubOwnerBean1;
    @FXML
    private Label labelEventName;
    @FXML
    private Label labelUsername;
    @FXML
    private TextArea textAreaResponse;
    private ReviewBean reviewBean;

    private MakeResponseGUIController1() {
        // ignored
    }

    public void setAll(UserBean1 userBean, ReviewBean reviewBean) throws SystemException {

        this.clubOwnerBean1 = LoggedClubOwnerBean1.getInstance();
        this.reviewBean=reviewBean;
        this.labelUsername.setText(userBean.getUsername());
        this.labelEventName.setText(MakeResponseAppController.searchEventbyIdEvent(reviewBean.getIdEvent()).getName());
    }
    public void createResponse(ActionEvent actionEvent) {

        try {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setResponse(textAreaResponse.getText());
            responseBean.setIdClubOwner(clubOwnerBean1.getId());
            responseBean.setReview(reviewBean.getIdReview());
            MakeResponseAppController.makeResponse(responseBean);
            SwitchPage.replaceScene(actionEvent,"/ReviewResponsePage1.fxml");
        } catch (SystemException | EmptyInputException e) {
            CreateNotification.createNotification(e);
        }
    }
    public void backToReviewsPage(ActionEvent actionEvent) {SwitchPage.replaceScene(actionEvent,"/ReviewResponsePage1.fxml");}
}
