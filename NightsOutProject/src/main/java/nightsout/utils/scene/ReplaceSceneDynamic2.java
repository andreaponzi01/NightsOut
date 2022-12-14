package nightsout.utils.scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import nightsout.control.guicontroller.interface2.ClubOwnerPageGUIController2;
import nightsout.control.guicontroller.interface2.LoginClubOwnerGUIController2;
import nightsout.control.guicontroller.interface2.UserPageGUIController2;
import nightsout.utils.bean.*;
import nightsout.utils.exception.ExceptionHandler;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.exception.myexception.WrongInputTypeException;
import nightsout.utils.scene.scenesetter.*;
import nightsout.utils.scene.scenesetter2.ClubOwnerPageSetter2;
import nightsout.utils.scene.scenesetter2.UserPageSetter2;

import java.io.IOException;

public class ReplaceSceneDynamic2 {

    public void switchAndSetScene(ActionEvent ae, String fxml) throws SystemException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            if (fxml.equals("/UserPage2.fxml")) {
                //UserPageSetter2.setter(loader.getController());
                UserPageGUIController2 controller =loader.getController();
                controller.setAll();
            }
            if (fxml.equals("/ClubOwnerPage2.fxml")) {
                ClubOwnerPageSetter2.setter(loader.getController());
            }
            ReplaceScene.showStage(ae, root);

        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

}
