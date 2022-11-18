package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nightsout.control.appcontroller.CreateEventReviewAppController;
import nightsout.control.appcontroller.EventReviewsClubOwnerAppController;
import nightsout.control.appcontroller.MakeResponseAppController;
import nightsout.utils.bean.*;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;

public class MakeResponseGUIController1 {
    private ClubOwnerBean clubOwnerBean;
    private ResponseBean responseBean;
    @FXML
    private Label labelEventName;
    @FXML
    private Label labelUsername;
    @FXML
    private TextField textFieldResponse;
    private ReviewBean reviewBean;
    private EventBean eventBean;

    public MakeResponseGUIController1() {
        //ignore
    }

    public void createResponse(ActionEvent actionEvent) throws IOException {
        //da fare

        if(!textFieldResponse.getText().isBlank())
        {
            responseBean= new ResponseBean();
            responseBean.setResponse(textFieldResponse.getText());
            responseBean.setIdClubOwner(clubOwnerBean.getId());
            responseBean.setReview(reviewBean.getIdReview());

            MakeResponseAppController.makeResponse(responseBean);
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneReviewResponse(actionEvent, "/ReviewResponsePage1.fxml", clubOwnerBean);
        }
        else
        {
            System.out.println("\n\nINSERISCI UN RESPONSO IPOCRITA!!!!!\n\n");
        }

    }

    public void backToReviewsPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneReviewResponse(actionEvent, "/ReviewResponsePage1.fxml", clubOwnerBean);
    }



    public void setAll(ClubOwnerBean clubOwnerBean, UserBean userBean, ReviewBean reviewBean) {
        this.clubOwnerBean=clubOwnerBean;
        this.reviewBean=reviewBean;
        this.labelUsername.setText(userBean.getUsername());
        this.eventBean= MakeResponseAppController.searchEventbyIdEvent(reviewBean.getIdEvent());
        this.labelEventName.setText(eventBean.getName());
    }
}
