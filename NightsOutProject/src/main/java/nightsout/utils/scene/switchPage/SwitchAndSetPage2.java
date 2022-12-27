package nightsout.utils.scene.switchPage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.bean.interface2.ClubOwnerBean2;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.initPage2.*;

import java.io.IOException;

public class SwitchAndSetPage2 {

    public void switchAndSetScene(ActionEvent ae, String fxml) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            if (fxml.equals("/CheckRequestsAndReviewPage2.fxml")) {
                InitCheckRequestsAndReviewPage2.setter(loader.getController());
            }
            if (fxml.equals("/ClubOwnerPage2.fxml")) {
                InitClubOwnerPage2.setter(loader.getController());
            }
            SwitchPage.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneEvent(ActionEvent ae, String fxml, EventBean2 eventBean) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            /*
            if (fxml.equals("/EventPageFromCO2.fxml")) {
                InitEventPage2.setterCO(eventBean,loader.getController());
            }
             */
            if (fxml.equals("/EventPageFromUser2.fxml")) {
                InitEventPage2.setterUser(eventBean,loader.getController());
            }
            if (fxml.equals("/EventParticipantsPage2.fxml")) {
                InitParticipantsPage2.setter(eventBean,loader.getController());
            }
            SwitchPage.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public void switchAndSetSceneCO(ActionEvent ae, String fxml, ClubOwnerBean2 clubOwnerBean) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            if (fxml.equals("/ViewCOPageFromUser2.fxml")) {
                InitViewCOPage2.setterUser(clubOwnerBean,loader.getController());
            }
            SwitchPage.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
            e.printStackTrace();
        }
    }
    public void switchAndSetSceneUser(ActionEvent ae, String fxml, UserBean2 userBean) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            if (fxml.equals("/ViewUserPageFromUser2.fxml")) {
                InitViewUserPage2.setterUser(userBean,loader.getController());
            }
            if (fxml.equals("/ViewUserPageFromCO2.fxml")) {
                //InitViewUserPage2.setterCO(userBean,loader.getController());
            }
            SwitchPage.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
            e.printStackTrace();
        }
    }

}
