package nightsout.utils.decorator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nightsout.control.appcontroller.RequestAppController;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.scene.ReplaceSceneDynamic1;

import java.io.IOException;

public class ConcreteDecoratorSendRequest extends Decorator {

    private UserBean userBean;
    private EventBean eventBean;
    private String oldFxml;

    String toWrite;

    public ConcreteDecoratorSendRequest(VisualComponent component, UserBean userBean, EventBean eventBean, String oldFxml) {
        super(component);
        this.userBean = userBean;
        this.eventBean = eventBean;
        this.oldFxml = oldFxml;
    }

    protected void applyDecorationSendRequest(Button myButton) {
        myButton.setText(toWrite);
        myButton.setMinHeight(65);
        myButton.setMinWidth(125);
        Font font = Font.font("Arial", FontWeight.BOLD, 25);
        myButton.setFont(font);
        myButton.setStyle("-fx-background-color: #d00000;" + "-fx-background-radius: 28;" + "-fx-text-fill: white;");
        myButton.setOnAction((ActionEvent ae) -> sendRequest(ae));
    }

    private void backToWelcomePage(ActionEvent ae, String fxml, UserBean userBean) {
        try {
            ReplaceSceneDynamic1 replaceSceneDynamic1 = new ReplaceSceneDynamic1();
            replaceSceneDynamic1.switchAndSetScene(ae, fxml, userBean, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendRequest(ActionEvent actionEvent) {
        try {
            RequestAppController.sendRequest(this.userBean, eventBean);
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneEvent(actionEvent, "/EventPageDecorator1.fxml", userBean, eventBean, oldFxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Button getButton() {
        Button myButton = super.getButton();
        this.toWrite = "Send Request";
        this.applyDecorationSendRequest(myButton);
        return myButton;
    }

}
