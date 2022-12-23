package nightsout.utils.scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.initPage2.InitClubOwnerPage2;
import nightsout.utils.scene.switchPage.SwitchPage;

import java.io.IOException;

public class ReplaceSceneDynamic2 {

    public void switchAndSetScene(ActionEvent ae, String fxml) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            if (fxml.equals("/ClubOwnerPage2.fxml")) {
                InitClubOwnerPage2.setter(loader.getController());
            }
            SwitchPage.showStage(ae, root);

        } catch (IOException e) {
            ExceptionHandler.handleException(e);
            e.printStackTrace();
        }
    }

}
