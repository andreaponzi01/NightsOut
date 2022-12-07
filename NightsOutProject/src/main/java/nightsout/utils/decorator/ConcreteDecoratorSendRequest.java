package nightsout.utils.decorator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nightsout.control.appcontroller.RequestAppController;
import nightsout.control.guicontroller.MyNotification;
import nightsout.utils.bean.EventBean;
import nightsout.utils.bean.LoggedUserBean;
import nightsout.utils.bean.UserBean;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.scene.ReplaceSceneDynamic1;

public class ConcreteDecoratorSendRequest extends Decorator {

    private UserBean userBean;
    private EventBean eventBean;

    String toWrite;

    public ConcreteDecoratorSendRequest(VisualComponent component, EventBean eventBean) {
        super(component);
        this.userBean = LoggedUserBean.getInstance();
        this.eventBean = eventBean;
    }

    protected void applyDecorationSendRequest(Button myButton) {
        myButton.setText(toWrite);
        myButton.setMinHeight(65);
        myButton.setMinWidth(125);
        Font font = Font.font("Arial", FontWeight.BOLD, 25);
        myButton.setFont(font);
        myButton.setStyle("-fx-background-color: #b3b3ff;" + "-fx-background-radius: 28;" + "-fx-text-fill: white;");
        myButton.setOnAction((ActionEvent ae) -> sendRequest(ae));
    }

    private void sendRequest(ActionEvent actionEvent){
        try {
            RequestAppController.sendRequest(this.userBean, eventBean);
            ReplaceSceneDynamic1 replacer = new ReplaceSceneDynamic1();
            replacer.switchAndSetSceneEventUser(actionEvent, "/EventPageDecoratorUser1.fxml", eventBean);
        } catch (SystemException e){
            MyNotification.createNotification(e);
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
