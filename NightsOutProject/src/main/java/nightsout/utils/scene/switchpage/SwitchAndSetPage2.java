package nightsout.utils.scene.switchpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import nightsout.utils.bean.interface2.ClubOwnerBean2;
import nightsout.utils.bean.interface2.EventBean2;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.initpage2.InitEventPage2;
import nightsout.utils.scene.initpage2.InitParticipantsPage2;
import nightsout.utils.scene.initpage2.InitViewCOPage2;
import nightsout.utils.scene.initpage2.InitViewUserPage2;

import java.io.IOException;

public class SwitchAndSetPage2 {

    public void switchAndSetSceneEvent(ActionEvent ae, String fxml, EventBean2 eventBean) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(SwitchAndSetPage2.class.getResource(fxml));
            Parent root = loader.load();
            if (fxml.equals("/EventPageFromCO2.fxml")) {
                InitEventPage2 initEventPage2 = new InitEventPage2();
                initEventPage2.setter(eventBean,loader.getController());
            }
            if (fxml.equals("/EventPageFromUser2.fxml")) {
                InitEventPage2 initEventPage2 = new InitEventPage2();
                initEventPage2.setter(eventBean,loader.getController());
            }
            if (fxml.equals("/EventParticipantsPageFromUser2.fxml")) {
                InitParticipantsPage2 initParticipantsPage2 = new InitParticipantsPage2();
                initParticipantsPage2.setter(eventBean,loader.getController());
            }
            if (fxml.equals("/EventParticipantsPageFromCO2.fxml")) {
                InitParticipantsPage2 initParticipantsPage2 = new InitParticipantsPage2();
                initParticipantsPage2.setter(eventBean,loader.getController());
            }
            SwitchPage.showStage(ae, root);
        } catch (IOException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
    public void switchAndSetSceneCO(ActionEvent ae, String fxml, ClubOwnerBean2 clubOwnerBean) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(SwitchAndSetPage2.class.getResource(fxml));
            Parent root = loader.load();
            if (fxml.equals("/ViewCOPageFromUser2.fxml")) {
                InitViewCOPage2 initViewCOPage2 = new InitViewCOPage2();
                initViewCOPage2.setter(clubOwnerBean,loader.getController());
            }
            if (fxml.equals("/ViewCOPageFromCO2.fxml")) {
                InitViewCOPage2 initViewCOPage2 = new InitViewCOPage2();
                initViewCOPage2.setter(clubOwnerBean,loader.getController());
            }
            SwitchPage.showStage(ae, root);
        } catch (IOException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }

    public void switchAndSetSceneUser(ActionEvent ae, String fxml, UserBean2 userBean) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(SwitchAndSetPage2.class.getResource(fxml));
            Parent root = loader.load();
            if (fxml.equals("/ViewUserPageFromUser2.fxml")) {
                InitViewUserPage2 initViewUserPage2 = new InitViewUserPage2();
                initViewUserPage2.setter(userBean,loader.getController());
            }
            if (fxml.equals("/ViewUserPageFromCO2.fxml")) {
                InitViewUserPage2 initViewUserPage2 = new InitViewUserPage2();
                initViewUserPage2.setter(userBean, loader.getController());
            }
            SwitchPage.showStage(ae, root);
        } catch (IOException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}
