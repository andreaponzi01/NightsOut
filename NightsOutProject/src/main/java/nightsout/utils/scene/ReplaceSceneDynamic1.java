package nightsout.utils.scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.*;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.exception.myexception.WrongInputTypeException;
import nightsout.utils.scene.scenesetter.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ReplaceSceneDynamic1 {

    public void switchAndSetScene(ActionEvent ae, String fxml) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();


            if (fxml.equals("/UserPage1.fxml")) {
                UserPageSetter1.setterCulo(loader.getController());
            }
            if (fxml.equals("/ClubOwnerPage1.fxml")) {
                ClubOwnerPageSetter1.setterCulo(loader.getController());
            }
            ReplaceScene.showStage(ae, root);

        } catch (IOException | SQLException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneViewUserPageFromCO(ActionEvent ae, String fxml, UserBean userBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            ViewUserPageSetter1.setterCO(userBean,loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (IOException | SQLException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneViewUserPageFromUser(ActionEvent ae, String fxml, UserBean userBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            ViewUserPageSetter1.setterUser(userBean,loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneViewClubOwnerPage(ActionEvent ae, String fxml, ClubOwnerBean clubOwnerBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();


            if (fxml.equals("/ViewClubOwnerPage1.fxml")) {
                ClubOwnerPageSetter1.setterItem(clubOwnerBean, loader.getController());
            }
            ReplaceScene.showStage(ae, root);
        } catch (SQLException | IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneRegister(ActionEvent ae, String fxml, String[] personalInfo, String type) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            if (Objects.equals(type, "ClubOwner")) {
                RegisterSetter1.setterClubOwner(personalInfo, loader.getController());
            } else if (Objects.equals(type, "Free")){
                RegisterSetter1.setterUser(personalInfo, loader.getController());
            }
            ReplaceScene.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        } catch (WrongInputTypeException | EmptyInputException e) {
            MyNotification.createNotification(e);
        }
    }

    public void switchAndSetSceneCreateEvent(ActionEvent ae, String fxml) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            RegisterSetter1.setterCreateEvent(loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (IOException | SQLException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneSubscription(ActionEvent ae, String fxml) throws SystemException {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            UserBean userBean=LoggedUserBean.getInstance();

            if(userBean.getVip()){
                SubscriptionPageSetter1.setter2(loader.getController());
                ReplaceScene.showStage(ae, root);
            } else {
                SubscriptionPageSetter1.setter1(loader.getController());
                ReplaceScene.showStage(ae, root);
            }
        } catch (IOException | SQLException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneSearch(ActionEvent ae, String fxml) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            SearchPageSetter1.setter( loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneManageRequest(ActionEvent ae, String fxml) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            ManageRequestSetter1.setter( loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (SQLException | IOException e) {
            ExceptionHandler.handleException(e);
        }
    }


    public void switchAndSetSceneCheckPendingRequests(ActionEvent actionEvent, String fxml) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            CheckRequestSetter1.setterPending(loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        }catch (SQLException | IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneCheckRifiutedRequests(ActionEvent actionEvent, String fxml) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            CheckRequestSetter1.setterRifiuted(loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        }catch (SQLException | IOException e) {
            ExceptionHandler.handleException(e);
        }
    }



    public void switchAndSetSceneEndedBookedEvents(ActionEvent actionEvent, String fxml) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            EndedBookedEventsPageSetter1.setter(loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (SQLException | IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneCreateEventReview(ActionEvent actionEvent, String fxml, EventBean eventBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            ReviewPageSetter1.setter(eventBean, loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (SQLException | IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneReviewResponse(ActionEvent actionEvent, String fxml) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            ResponsePageSetter1.setter(loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (SQLException | IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneMakeResponse(ActionEvent actionEvent, String fxml, UserBean userBean, ReviewBean reviewBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            ResponsePageSetter1.setter2(userBean,reviewBean, loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (SQLException | IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneReviewAndResponse(ActionEvent actionEvent, String fxml) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            ReviewAndResponsePageSetter1.setter(loader.getController());
            ReplaceScene.showStage(actionEvent, root);
        } catch (SQLException | IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneEventUser(ActionEvent ae, String fxml, EventBean eventBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            EventPageSetter1.setterDecoratorUser( eventBean, loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (SQLException | IOException e) {
            ExceptionHandler.handleException(e);
        }
    }
    public void switchAndSetSceneEventCO(ActionEvent ae, String fxml, EventBean eventBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            EventPageSetter1.setterDecoratorCO( eventBean, loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (SQLException | IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneMap(ActionEvent ae, String fxml, EventBean eventBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            MapPageSetter1.setter(eventBean,loader.getController());
            ReplaceScene.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }



}
