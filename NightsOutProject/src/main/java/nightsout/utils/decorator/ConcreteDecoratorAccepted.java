package nightsout.utils.decorator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.LoggedUserBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;

public class ConcreteDecoratorAccepted extends Decorator {

    private UserBean userBean;

    String toWrite;

    public ConcreteDecoratorAccepted(VisualComponent component) {
        super(component);
        this.userBean = LoggedUserBean.getInstance();
    }

    protected void applyDecorationAccepted(Button myButton) {
        myButton.setText(toWrite);
        myButton.setMinHeight(65);
        myButton.setMinWidth(125);
        Font font = Font.font("Arial", FontWeight.BOLD, 25);
        myButton.setFont(font);
        myButton.setStyle("-fx-background-color: #32a844;" + "-fx-background-radius: 28;" + "-fx-text-fill: white;");
    }

    @Override
    public Button getButton() {
        Button myButton = super.getButton();
        this.toWrite = "Accepted";
        this.applyDecorationAccepted(myButton);
        return myButton;
    }

}
