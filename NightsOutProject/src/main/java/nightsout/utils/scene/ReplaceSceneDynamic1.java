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

    public void switchAndSetSceneViewUserPageFromCO(ActionEvent ae, String fxml, UserBean1 userBean) throws SystemException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            ViewUserPageSetter1.setterCO(userBean,loader.getController());
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }

}
