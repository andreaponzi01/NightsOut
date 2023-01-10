package nightsout.utils.scene.switchpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import nightsout.utils.bean.interface2.ClubOwnerBean2;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.initpage2.InitEventPage2;
import nightsout.utils.scene.initpage2.InitParticipantsPage2;
import nightsout.utils.scene.initpage2.InitViewCOPage2;
import nightsout.utils.scene.initpage2.InitViewUserPage2;

import java.io.IOException;

public class SwitchAndSetPage2 {

    private SwitchAndSetPage2() {
        // ignored
    }

    public static void switchAndSetSceneEvent(ActionEvent ae, String fxml, EventBean2 eventBean) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(SwitchAndSetPage2.class.getResource(fxml));
            Parent root = loader.load();
            if (fxml.equals("/EventPageFromCO2.fxml")) {InitEventPage2.setterCO(eventBean,loader.getController());}
            if (fxml.equals("/EventPageFromUser2.fxml")) {InitEventPage2.setterUser(eventBean,loader.getController());}
            if (fxml.equals("/EventParticipantsPageFromUser2.fxml")) {InitParticipantsPage2.setter(eventBean,loader.getController());}
            if (fxml.equals("/EventParticipantsPageFromCO2.fxml")) {InitParticipantsPage2.setter(eventBean,loader.getController());}
            SwitchPage.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }
    public static void switchAndSetSceneCO(ActionEvent ae, String fxml, ClubOwnerBean2 clubOwnerBean) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(SwitchAndSetPage2.class.getResource(fxml));
            Parent root = loader.load();
            if (fxml.equals("/ViewCOPageFromUser2.fxml")) {InitViewCOPage2.setter(clubOwnerBean,loader.getController());}
            if (fxml.equals("/ViewCOPageFromCO2.fxml")) {InitViewCOPage2.setter(clubOwnerBean,loader.getController());}
            SwitchPage.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public static void switchAndSetSceneUser(ActionEvent ae, String fxml, UserBean2 userBean) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(SwitchAndSetPage2.class.getResource(fxml));
            Parent root = loader.load();
            if (fxml.equals("/ViewUserPageFromUser2.fxml")) {InitViewUserPage2.setter(userBean,loader.getController());}
            if (fxml.equals("/ViewUserPageFromCO2.fxml")) {InitViewUserPage2.setter(userBean,loader.getController());}
            SwitchPage.showStage(ae, root);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }
}
