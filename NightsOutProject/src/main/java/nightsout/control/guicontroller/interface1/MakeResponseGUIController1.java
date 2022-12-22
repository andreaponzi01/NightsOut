package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import nightsout.control.appcontroller.MakeResponseAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.*;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

public class MakeResponseGUIController1 {
    private ClubOwnerBean1 clubOwnerBean1;
    @FXML
    private Label labelEventName;
    @FXML
    private Label labelUsername;
    @FXML
    private TextArea textFieldResponse;
    private ReviewBean reviewBean;

    public MakeResponseGUIController1() {
        //ignore
    }

    public void setAll(UserBean1 userBean1, ReviewBean reviewBean) throws SystemException {

        this.clubOwnerBean1 = LoggedClubOwnerBean1.getInstance();
        this.reviewBean=reviewBean;
        this.labelUsername.setText(userBean1.getUsername());
        this.labelEventName.setText(MakeResponseAppController.searchEventbyIdEvent(reviewBean.getIdEvent()).getName());
    }
    public void createResponse(ActionEvent actionEvent) {

        try {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setResponse(textFieldResponse.getText());
            responseBean.setIdClubOwner(clubOwnerBean1.getId());
            responseBean.setReview(reviewBean.getIdReview());

            MakeResponseAppController.makeResponse(responseBean);
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneReviewResponse(actionEvent, "/ReviewResponsePage1.fxml");

        } catch (SystemException | EmptyInputException e) {
            MyNotification.createNotification(e);
        }
    }

    public void backToReviewsPage(ActionEvent actionEvent) {

        try {
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneReviewResponse(actionEvent, "/ReviewResponsePage1.fxml");
        } catch (SystemException e) {
            MyNotification.createNotification(e);
        }
    }
}
