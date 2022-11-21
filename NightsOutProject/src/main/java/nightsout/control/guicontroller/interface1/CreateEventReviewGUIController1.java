package nightsout.control.guicontroller.interface1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nightsout.control.appcontroller.CreateEventReviewAppController;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;

public class CreateEventReviewGUIController1 {

    private EventBean eventBean;
    private ReviewBean reviewBean;
    private UserBean userBean;
    @FXML
    private Label labelEventName;

    @FXML
    private TextField textFieldReview;

    public CreateEventReviewGUIController1() {
        //ignore
    }


    public void createReview(ActionEvent actionEvent) throws IOException {

        if(!textFieldReview.getText().isBlank())
        {
            reviewBean= new ReviewBean();
            reviewBean.setComment(textFieldReview.getText());
            reviewBean.setIdUser(userBean.getId());
            reviewBean.setIdEvent(eventBean.getIdEvent());


            CreateEventReviewAppController.createEventReview(reviewBean);
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetScene(actionEvent, "/UserPage1.fxml", userBean, null);
        }
        else
        {
            System.out.println("\n\nINSERISCI UN COMMENT IPOCRITA!!!!!\n\n");
        }
    }

    public void backToEndedBookedEventsPage(ActionEvent actionEvent) throws IOException {
        ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
        replacer.switchAndSetSceneEndedBookedEvents(actionEvent, "/EndedBookedEventsPage1.fxml", userBean);
    }

    public void setAll(EventBean eventBean, UserBean userBean){
        this.userBean=userBean;
        this.eventBean=eventBean;
        this.labelEventName.setText(eventBean.getName());
    }
}