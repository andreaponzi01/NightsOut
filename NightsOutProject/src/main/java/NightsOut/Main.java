package NightsOut;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

            System.out.println("Ciao1");
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/Welcome_1.fxml"));
            System.out.println("Ciao2");
            Scene scene = new Scene(loader.load());
            System.out.println("Ciao3");
            stage.setScene(scene);
            stage.setTitle("NightsOut");
            stage.show();
            System.out.println("Ciao4");
    }

    public static void main(String[] args) {
        launch();
    }
}

