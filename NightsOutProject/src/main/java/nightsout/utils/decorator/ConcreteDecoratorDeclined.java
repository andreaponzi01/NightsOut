package nightsout.utils.decorator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nightsout.utils.bean.LoggedUserBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;

public class ConcreteDecoratorDeclined extends Decorator {

    private UserBean userBean;

    String toWrite;

    public ConcreteDecoratorDeclined(VisualComponent component) {
        super(component);
        this.userBean = LoggedUserBean.getInstance();
    }

    protected void applyDecorationDeclined(Button myButton) {
        myButton.setText(toWrite);
        myButton.setMinHeight(65);
        myButton.setMinWidth(125);
        Font font = Font.font("Arial", FontWeight.BOLD, 25);
        myButton.setFont(font);
        myButton.setStyle("-fx-background-color: #d00000;" + "-fx-background-radius: 28;" + "-fx-text-fill: white;");
    }

    @Override
    public Button getButton() {
        Button myButton = super.getButton();
        this.toWrite = "Declined";
        this.applyDecorationDeclined(myButton);
        return myButton;
    }

}
