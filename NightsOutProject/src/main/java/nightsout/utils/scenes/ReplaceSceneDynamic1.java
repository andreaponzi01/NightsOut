package nightsout.utils.scenes;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scenes.interface1.ClubOwnerPageSetter1;
import nightsout.utils.scenes.interface1.RegisterSetter1;
import nightsout.utils.scenes.interface1.UserPageSetter1;

import java.io.IOException;
import java.util.Objects;

public class ReplaceSceneDynamic1 {

    public void switchAndSetScene(ActionEvent ae, String fxml, UserBean userBean, ClubOwnerBean clubOwnerBean) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();

        try {

            if (fxml.equals("/UserPage1.fxml")) {
                UserPageSetter1.setter(userBean, loader.getController());
            }
            if (fxml.equals("/ClubOwnerPage1.fxml")) {
               ClubOwnerPageSetter1.setter(clubOwnerBean, loader.getController());
            }

            ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }

    public void switchAndSetSceneRegister(ActionEvent ae, String fxml, String[] personalInfo, String type) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        try {
            if (Objects.equals(type, "ClubOwner")) {
                RegisterSetter1.setterClubOwner(personalInfo, type, loader.getController());
            } else if (Objects.equals(type, "Free")){
                RegisterSetter1.setterUser(personalInfo, type, loader.getController());
            }
            ReplaceScene.showStage(ae, root);
        } catch (Exception /*| IOException*/ e) {
            e.printStackTrace();
        }
    }
}
