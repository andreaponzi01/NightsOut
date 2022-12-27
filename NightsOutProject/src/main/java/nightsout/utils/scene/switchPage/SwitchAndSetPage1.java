package nightsout.utils.scene.switchPage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import nightsout.utils.bean.*;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.initPage1.*;

import java.io.IOException;

public class SwitchAndSetPage1 {

    public void switchAndSetScene(ActionEvent ae, String fxml) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            if (fxml.equals("/CreateEventPage1.fxml")) {
                CreateEventSetter1.setterCreateEvent(loader.getController());
            }
            if (fxml.equals("/UserPage1.fxml")) {
                UserPageSetter1.setter(loader.getController());
            }
            if (fxml.equals("/ClubOwnerPage1.fxml")) {
                ClubOwnerPageSetter1.setter(loader.getController());
            }
            if (fxml.equals("/ReviewAndResponsePage1.fxml")) {
                ReviewAndResponsePageSetter1.setter(loader.getController());
            }
            if (fxml.equals("/ReviewResponsePage1.fxml")) {
                ResponsePageSetter1.setter(loader.getController());
            }
            if (fxml.equals("/EndedBookedEventsPage1.fxml")) {
                EndedBookedEventsPageSetter1.setter(loader.getController());
            }
            if (fxml.equals( "/CheckRifiutedRequestsPage1.fxml")) {
                RifiutedRequestsPageSetter1.setter(loader.getController());
            }
            if (fxml.equals( "/CheckPendingRequestsPage1.fxml")) {
                PendingRequestsPageSetter1.setter(loader.getController());
            }
            if (fxml.equals( "/SearchPage1.fxml")) {
                SearchPageSetter1.setter( loader.getController());
            }
            if (fxml.equals( "/ManageRequests1.fxml")) {
                ManageRequestSetter1.setter( loader.getController());
            }

            SwitchPage.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
            e.printStackTrace();
        }
    }


    public void switchAndSetSceneEvent(ActionEvent ae, String fxml, EventBean1 eventBean) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            if (fxml.equals("/MapPage1.fxml")) {
                MapPageSetter1.setter(eventBean, loader.getController());
            }
            if (fxml.equals("/EventPageDecoratorCO1.fxml")) {
                EventPageSetter1.setterDecoratorCO( eventBean, loader.getController());
            }
            if (fxml.equals("/EventPageDecoratorUser1.fxml")) {
                EventPageSetter1.setterDecoratorUser( eventBean, loader.getController());
            }
            if (fxml.equals("/CreateEventReviewPage1.fxml")) {
                ReviewPageSetter1.setter(eventBean, loader.getController());
            }

            SwitchPage.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneUser(ActionEvent ae, String fxml, UserBean1 userBean) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            if (fxml.equals("/ViewUserPageFromCO1.fxml")) {
                ViewUserPageSetter1.setterCO(userBean,loader.getController());
            }
            if (fxml.equals("/ViewUserPageFromUser1.fxml")) {
                ViewUserPageSetter1.setterUser(userBean,loader.getController());
            }
            if (fxml.equals("/ConcludeRegisterUser1.fxml")) {
                RegisterSetter1.setterUser(userBean, loader.getController());
            }

            SwitchPage.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneClubOwner(ActionEvent ae, String fxml, ClubOwnerBean1 clubOwnerBean) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            if (fxml.equals("/ViewClubOwnerPageFromCO1.fxml")) {
                ViewClubOwnerPageSetter1.setterViewFromCO(clubOwnerBean, loader.getController());
            }
            if (fxml.equals("/ViewClubOwnerPageFromUser1.fxml")) {
                ViewClubOwnerPageSetter1.setterViewFromUser(clubOwnerBean, loader.getController());
            }
            if (fxml.equals("/ConcludeRegisterClubOwner1.fxml")) {
                RegisterSetter1.setterClubOwner(clubOwnerBean, loader.getController());
            }
            if (fxml.equals("/ClubOwnerCommunityFromUser.fxml")) {
                InitCommunityPage.setterUser(loader.getController(),clubOwnerBean);
            }
            if (fxml.equals("/ClubOwnerCommunityFromCO.fxml")) {
                InitCommunityPage.setterCO(loader.getController(),clubOwnerBean);
            }

            SwitchPage.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneMakeResponse(ActionEvent actionEvent, String fxml, UserBean1 userBean, ReviewBean reviewBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            MakeResponsePageSetter1.setter(userBean,reviewBean, loader.getController());
            SwitchPage.showStage(actionEvent, root);
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
                SubscriptionPageSetter1.setterSubscriptioned(loader.getController());
                SwitchPage.showStage(ae, root);
            }
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }
}
