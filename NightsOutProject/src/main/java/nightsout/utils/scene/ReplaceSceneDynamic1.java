package nightsout.utils.scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import nightsout.utils.bean.*;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.exception.myexception.WrongInputTypeException;
import nightsout.utils.scene.scenesetter.*;

import java.io.IOException;

public class ReplaceSceneDynamic1 {

    public void switchAndSetScene(ActionEvent ae, String fxml) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();


            if (fxml.equals("/UserPage1.fxml")) {
                UserPageSetter1.setter(loader.getController());
            }
            if (fxml.equals("/ClubOwnerPage1.fxml")) {
                ClubOwnerPageSetter1.setter(loader.getController());
            }
            ReplaceScene.showStage(ae, root);

        } catch (IOException e) {
            ExceptionHandler.handleException(e);
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneViewUserPageFromCO(ActionEvent ae, String fxml, UserBean1 userBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            ViewUserPageSetter1.setterCO(userBean,loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneViewUserPageFromUser(ActionEvent ae, String fxml, UserBean1 userBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            ViewUserPageSetter1.setterUser(userBean,loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch  (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneViewClubOwnerPageFromUser(ActionEvent ae, String fxml, ClubOwnerBean1 clubOwnerBean1) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();


            if (fxml.equals("/ViewClubOwnerPageFromUser1.fxml")) {
                ClubOwnerPageSetter1.setterViewFromUser(clubOwnerBean1, loader.getController());
            }
            ReplaceScene.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneViewClubOwnerPageFromCO(ActionEvent ae, String fxml, ClubOwnerBean1 clubOwnerBean1) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();


            if (fxml.equals("/ViewClubOwnerPageFromCO1.fxml")) {
                ClubOwnerPageSetter1.setterViewFromCO(clubOwnerBean1, loader.getController());
            }
            ReplaceScene.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneRegisterUser(ActionEvent ae, String fxml, UserBean1 userBean) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            RegisterSetter1.setterUser(userBean, loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneRegisterClubOwner(ActionEvent ae, String fxml, ClubOwnerBean1 clubOwnerBean1) throws SystemException, WrongInputTypeException, EmptyInputException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            RegisterSetter1.setterClubOwner(clubOwnerBean1, loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneCreateEvent(ActionEvent ae, String fxml) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            RegisterSetter1.setterCreateEvent(loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneSubscription(ActionEvent ae, String fxml) throws SystemException {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            UserBean1 userBean = LoggedUserBean1.getInstance();

            if(userBean.getVip()){
                SubscriptionPageSetter1.setter(loader.getController());
                ReplaceScene.showStage(ae, root);
            } else {
                ReplaceScene.showStage(ae, root);
            }
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneSearch(ActionEvent ae, String fxml) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            SearchPageSetter1.setter( loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneManageRequest(ActionEvent ae, String fxml) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            ManageRequestSetter1.setter( loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }


    public void switchAndSetSceneCheckPendingRequests(ActionEvent actionEvent, String fxml) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            CheckRequestSetter1.setterPending(loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        }catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneCheckRifiutedRequests(ActionEvent actionEvent, String fxml) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            CheckRequestSetter1.setterRifiuted(loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        }catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }



    public void switchAndSetSceneEndedBookedEvents(ActionEvent actionEvent, String fxml) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            EndedBookedEventsPageSetter1.setter(loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneCreateEventReview(ActionEvent actionEvent, String fxml, EventBean1 eventBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            ReviewPageSetter1.setter(eventBean, loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneReviewResponse(ActionEvent actionEvent, String fxml) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            ResponsePageSetter1.setter(loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneMakeResponse(ActionEvent actionEvent, String fxml, UserBean1 userBean, ReviewBean reviewBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            ResponsePageSetter1.setter2(userBean,reviewBean, loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneReviewAndResponse(ActionEvent actionEvent, String fxml) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            ReviewAndResponsePageSetter1.setter(loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneEventUser(ActionEvent ae, String fxml, EventBean1 eventBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            EventPageSetter1.setterDecoratorUser( eventBean, loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }
    public void switchAndSetSceneEventCO(ActionEvent ae, String fxml, EventBean1 eventBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            EventPageSetter1.setterDecoratorCO( eventBean, loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneMap(ActionEvent ae, String fxml, EventBean1 eventBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            MapPageSetter1.setter(eventBean, loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneCommunityFromUser(ActionEvent actionEvent, String fxml, ClubOwnerBean1 clubOwnerBean1) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            CommunityFromUserSetter1.setter(loader.getController(), clubOwnerBean1);
            ReplaceScene.showStage(actionEvent, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneCommunityFromCO(ActionEvent actionEvent, String fxml, ClubOwnerBean1 clubOwnerBean1) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            CommunityFromCOSetter1.setter(loader.getController(), clubOwnerBean1);
            ReplaceScene.showStage(actionEvent, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }
}
