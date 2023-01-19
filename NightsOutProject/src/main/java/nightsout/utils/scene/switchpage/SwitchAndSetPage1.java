package nightsout.utils.scene.switchpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface1.ClubOwnerBean1;
import nightsout.utils.bean.interface1.EventBean1;
import nightsout.utils.bean.interface1.UserBean1;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.initpage1.*;

import java.io.IOException;

public class SwitchAndSetPage1 {

    public void switchAndSetSceneEvent(ActionEvent ae, String fxml, EventBean1 eventBean) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(SwitchAndSetPage1.class.getResource(fxml));
            Parent root = loader.load();

            if (fxml.equals("/MapPage1.fxml")) {
                MapPageSetter1 mapPageSetter1 = new MapPageSetter1();
                mapPageSetter1.setter(eventBean, loader.getController());
            }
            if (fxml.equals("/EventPageDecoratorCO1.fxml")) {
                EventPageSetter1 eventPageSetter1 = new EventPageSetter1();
                eventPageSetter1.setter( eventBean, loader.getController());
            }
            if (fxml.equals("/EventPageDecoratorUser1.fxml")) {
                EventPageSetter1 eventPageSetter1 = new EventPageSetter1();
                eventPageSetter1.setter( eventBean, loader.getController());
            }
            if (fxml.equals("/CreateEventReviewPage1.fxml")) {
                ReviewPageSetter1 reviewPageSetter1 = new ReviewPageSetter1();
                reviewPageSetter1.setter(eventBean, loader.getController());
            }
            SwitchPage.showStage(ae, root);
        } catch (IOException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    public void switchAndSetSceneUser(ActionEvent ae, String fxml, UserBean1 userBean) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(SwitchAndSetPage1.class.getResource(fxml));
            Parent root = loader.load();
            if (fxml.equals("/ViewUserPageFromCO1.fxml")) {
                ViewUserPageSetter1 viewUserPageSetter1 = new ViewUserPageSetter1();
                viewUserPageSetter1.setter(userBean,loader.getController());
            }
            if (fxml.equals("/ViewUserPageFromUser1.fxml")) {
                ViewUserPageSetter1 viewUserPageSetter1 = new ViewUserPageSetter1();
                viewUserPageSetter1.setter(userBean,loader.getController());
            }
            if (fxml.equals("/ConcludeRegisterUser1.fxml")) {
                RegisterSetter1 registerSetter1 = new RegisterSetter1();
                registerSetter1.setterUser(userBean, loader.getController());
            }
            SwitchPage.showStage(ae, root);
        } catch (IOException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    public void switchAndSetSceneClubOwner(ActionEvent ae, String fxml, ClubOwnerBean1 clubOwnerBean) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(SwitchAndSetPage1.class.getResource(fxml));
            Parent root = loader.load();

            if (fxml.equals("/ViewClubOwnerPageFromCO1.fxml")) {
                ViewClubOwnerPageSetter1 viewClubOwnerPageSetter1 = new ViewClubOwnerPageSetter1();
                viewClubOwnerPageSetter1.setterView(clubOwnerBean, loader.getController());
            }
            if (fxml.equals("/ViewClubOwnerPageFromUser1.fxml")) {
                ViewClubOwnerPageSetter1 viewClubOwnerPageSetter1 = new ViewClubOwnerPageSetter1();
                viewClubOwnerPageSetter1.setterView(clubOwnerBean, loader.getController());
            }
            if (fxml.equals("/ConcludeRegisterClubOwner1.fxml")) {
                RegisterSetter1 registerSetter1 = new RegisterSetter1();
                registerSetter1.setterClubOwner(clubOwnerBean, loader.getController());
            }
            if (fxml.equals("/ClubOwnerCommunityFromUser.fxml")) {
                InitCommunityPage initCommunityPage = new InitCommunityPage();
                initCommunityPage.setter(loader.getController(), clubOwnerBean);
            }
            if (fxml.equals("/ClubOwnerCommunityFromCO.fxml")) {
                InitCommunityPage initCommunityPage = new InitCommunityPage();
                initCommunityPage.setter(loader.getController(), clubOwnerBean);
            }
            SwitchPage.showStage(ae, root);
        } catch (IOException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    public void switchAndSetSceneMakeResponse(ActionEvent actionEvent, String fxml, UserBean1 userBean, ReviewBean reviewBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(SwitchAndSetPage1.class.getResource(fxml));
            Parent root = loader.load();
            MakeResponsePageSetter1 makeResponsePageSetter1 = new MakeResponsePageSetter1();
            makeResponsePageSetter1.setter(userBean,reviewBean, loader.getController());
            SwitchPage.showStage(actionEvent, root);
        } catch (IOException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
