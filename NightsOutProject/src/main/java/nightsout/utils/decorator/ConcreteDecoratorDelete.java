package nightsout.utils.decorator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;

public class ConcreteDecoratorDelete extends Decorator {

    private ClubOwnerBean clubOwnerBean;

    String toWrite;

    public ConcreteDecoratorDelete(VisualComponent component, ClubOwnerBean clubOwnerBean) {
        super(component);
        this.clubOwnerBean = clubOwnerBean;
    }

    protected void applyDecorationDelete(Button myButton) {
        myButton.setText(toWrite);
        myButton.setMinHeight(65);
        myButton.setMinWidth(125);
        Font font = Font.font("Arial", FontWeight.BOLD, 25);
        myButton.setFont(font);
        myButton.setStyle("-fx-background-color: #d00000;" + "-fx-background-radius: 28;" + "-fx-text-fill: white;");
        myButton.setOnAction((ActionEvent ae) -> backToWelcomePage(ae, "/UserPage1.fxml", this.clubOwnerBean));
    }

    private void backToWelcomePage(ActionEvent ae, String fxml, ClubOwnerBean clubOwnerBean) {
        try {
            ReplaceSceneDynamic1 replaceSceneDynamic1 = new ReplaceSceneDynamic1();
            replaceSceneDynamic1.switchAndSetScene(ae, fxml, null, clubOwnerBean);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Button getButton() {
        Button myButton = super.getButton();
        this.toWrite = "Delete";
        this.applyDecorationDelete(myButton);
        return myButton;
    }

}
