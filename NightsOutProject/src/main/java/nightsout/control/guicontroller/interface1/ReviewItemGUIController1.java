package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import nightsout.control.appcontroller.EventReviewsClubOwnerAppController;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;
import java.sql.SQLException;

public class ReviewItemGUIController1 {

    private UserBean userBean;
    private ReviewBean reviewBean;

    public ReviewItemGUIController1() {
        //ignore
    }

    @FXML
    private TextArea textAreaComment;
    @FXML
    private Label labelUsername; //renderlo bottone

    public void setAll(ReviewBean reviewBean) throws SQLException {
        this.reviewBean=reviewBean;
        this.textAreaComment.setText(reviewBean.getComment());
        this.userBean= EventReviewsClubOwnerAppController.searchUserbyIdUser(reviewBean.getIdUser());
        this.labelUsername.setText(userBean.getUsername()); //renderlo bottone
    }

    public void goToResponsePage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneMakeResponse(actionEvent, "/MakeResponsePage1.fxml", userBean, reviewBean);
    }

    public void goToUserPage(ActionEvent actionEvent) throws IOException, SQLException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneViewUserPageFromCO(actionEvent,"/ViewUserPageFromCO1.fxml",userBean);
    }
}
