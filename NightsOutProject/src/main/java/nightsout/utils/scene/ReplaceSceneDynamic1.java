package nightsout.utils.scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import nightsout.utils.bean.*;
import nightsout.utils.scene.scenesetter.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ReplaceSceneDynamic1 {

    public void switchAndSetScene(ActionEvent ae, String fxml) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();

        try {
            if (fxml.equals("/UserPage1.fxml")) {
                UserPageSetter1.setterCulo(loader.getController());
            }
            if (fxml.equals("/ClubOwnerPage1.fxml")) {
                ClubOwnerPageSetter1.setterCulo(loader.getController());
            }
            ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneViewUserPageFromCO(ActionEvent ae, String fxml, UserBean userBean) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            ViewUserPageSetter1.setterCO(userBean,loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneViewUserPageFromUser(ActionEvent ae, String fxml, UserBean userBean) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            ViewUserPageSetter1.setterUser(userBean,loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneViewClubOwnerPage(ActionEvent ae, String fxml, ClubOwnerBean clubOwnerBean) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();

        try {
            if (fxml.equals("/ViewClubOwnerPage1.fxml")) {
                ClubOwnerPageSetter1.setterItem(clubOwnerBean, loader.getController());
            }
            ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneRegister(ActionEvent ae, String fxml, String[] personalInfo, String type) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            if (Objects.equals(type, "ClubOwner")) {
                RegisterSetter1.setterClubOwner(personalInfo, loader.getController());
            } else if (Objects.equals(type, "Free")){
                RegisterSetter1.setterUser(personalInfo, loader.getController());
            }
            ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneCreateEvent(ActionEvent ae, String fxml) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            RegisterSetter1.setterCreateEvent(loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneSubscription(ActionEvent ae, String fxml) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        UserBean userBean=LoggedUserBean.getInstance();
        try {
            if(userBean.getVip()){
                SubscriptionPageSetter1.setter2(loader.getController());
                ReplaceScene.showStage(ae, root);
            } else {
                SubscriptionPageSetter1.setter1(loader.getController());
                ReplaceScene.showStage(ae, root);
            }
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneSearch(ActionEvent ae, String fxml) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
                SearchPageSetter1.setter( loader.getController());
                ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneManageRequest(ActionEvent ae, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            ManageRequestSetter1.setter( loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneCheckRequests(ActionEvent actionEvent, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            CheckRequestSetter1.setter(loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }



    public void switchAndSetSceneEndedBookedEvents(ActionEvent actionEvent, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            EndedBookedEventsPageSetter1.setter(loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneCreateEventReview(ActionEvent actionEvent, String fxml, EventBean eventBean) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            ReviewPageSetter1.setter(eventBean, loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneReviewResponse(ActionEvent actionEvent, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            ResponsePageSetter1.setter(loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneMakeResponse(ActionEvent actionEvent, String fxml, UserBean userBean, ReviewBean reviewBean) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            ResponsePageSetter1.setter2(userBean,reviewBean, loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneReviewAndResponse(ActionEvent actionEvent, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            ReviewAndResponsePageSetter1.setter(loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneEventUser(ActionEvent ae, String fxml, EventBean eventBean) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            EventPageSetter1.setterDecoratorUser( eventBean, loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }
    public void switchAndSetSceneEventCO(ActionEvent ae, String fxml, EventBean eventBean) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            EventPageSetter1.setterDecoratorCO( eventBean, loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

}
