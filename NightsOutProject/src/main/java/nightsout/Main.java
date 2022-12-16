package nightsout;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.exception.myexception.SystemException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/Welcome1.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("NightsOut");
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    try {
                        FileUtils.cleanDirectory(new File("eventImgs"));
                        FileUtils.cleanDirectory(new File("profileImgs"));
                    } catch (IOException e) {
                        SystemException ex = new SystemException();
                        ex.initCause(e);
                        MyNotification.createNotification(ex);
                    }
                }
            });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}