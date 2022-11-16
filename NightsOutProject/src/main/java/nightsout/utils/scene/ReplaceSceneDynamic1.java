package nightsout.utils.scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.scenesetter.*;

import java.io.IOException;
import java.util.Objects;

public class ReplaceSceneDynamic1 {

    public void switchAndSetScene(ActionEvent ae, String fxml, UserBean userBean, ClubOwnerBean clubOwnerBean) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();

        try {
            if (fxml.equals("/UserPage1.fxml")) {
                UserPageSetter1.setter(userBean, loader.getController());
            }
            if (fxml.equals("/ClubOwnerPage1.fxml")) {
               ClubOwnerPageSetter1.setter(clubOwnerBean, loader.getController());
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

    public void switchAndSetSceneCreateEvent(ActionEvent ae, String fxml, ClubOwnerBean clubOwnerBean) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            RegisterSetter1.setterCreateEvent(clubOwnerBean, loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneSubscription(ActionEvent ae, String fxml, UserBean userBean) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            if(userBean.getVip()){
                SubscriptionPageSetter1.setter2(userBean, loader.getController());
                ReplaceScene.showStage(ae, root);
            } else {
                SubscriptionPageSetter1.setter1(userBean, loader.getController());
                ReplaceScene.showStage(ae, root);
            }
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneSearch(ActionEvent ae, String fxml, UserBean userBean) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
                SearchPageSetter1.setter(userBean, loader.getController());
                ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneEvent(ActionEvent ae, String fxml, EventBean eventBean, UserBean userBean, String oldInput) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            if(fxml.equals("/EventPageSendRequest1.fxml")) {
                EventPageSetter1.setter1(userBean, eventBean, oldInput, loader.getController());
            }
            if(fxml.equals("/EventPagePendingRequest1.fxml")) {
                EventPageSetter1.setter2(userBean, eventBean, oldInput, loader.getController());
            }
            if(fxml.equals("/EventPageAcceptedRequest1.fxml")) {
                EventPageSetter1.setter2(userBean, eventBean, oldInput, loader.getController());
            }
            if(fxml.equals("/EventPageDeclinedRequest1.fxml")) {
                EventPageSetter1.setter2(userBean, eventBean, oldInput, loader.getController());
            }
            ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneOldSearch(ActionEvent ae, String fxml, UserBean userBean, String oldInput) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            SearchPageSetter1.setter2(userBean, oldInput, loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneManageRequest(ActionEvent ae, String fxml, ClubOwnerBean clubOwnerBean) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            ManageRequestSetter1.setter(clubOwnerBean, loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneCheckRequests(ActionEvent actionEvent, String fxml, UserBean userBean) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            CheckRequestSetter1.setter(userBean, loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneNextEvents(ActionEvent actionEvent, String fxml, UserBean userBean, EventBean eventBean) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            EventPageSetter1.setter3(userBean,eventBean, loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneCreatedEvents(ActionEvent actionEvent, String fxml, ClubOwnerBean clubOwnerBean, EventBean eventBean) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            EventPageSetter1.setterClubOwner(clubOwnerBean,eventBean, loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }
}