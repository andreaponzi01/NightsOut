package nightsout.utils.scene.switchpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nightsout.Main;
import nightsout.utils.exception.ExceptionHandler;

import java.io.IOException;

public class SwitchPage {

    private SwitchPage(){
        //ignored
    }

    public static void replaceScene(ActionEvent ae, String fxml){

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
        stage.setScene(scene);
        stage.show();
    }

    // Root già caricato, non c'è bisogno di fare il loader.load()
    public static void showStage(ActionEvent ae, Parent root){
        Stage stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
